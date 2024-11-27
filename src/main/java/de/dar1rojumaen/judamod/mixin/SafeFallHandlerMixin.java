package de.dar1rojumaen.judamod.mixin;

import com.google.common.collect.Multimap;
import de.dar1rojumaen.judamod.jumaen.attribute.JuModAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(PlayerEntity.class)
public abstract class SafeFallHandlerMixin extends LivingEntity {

    protected SafeFallHandlerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void modifyFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        // Get the safe fall distance from equipment or attributes
        double safeFallDistance = getSafeFallDistanceFromEquipment();
        if (fallDistance > safeFallDistance) {
            // Calculate the adjusted fall distance beyond the safe range
            float adjustedFallDistance = (float) (fallDistance - safeFallDistance);

            // Calculate the actual damage for the remaining distance
            float actualDamage = (adjustedFallDistance - 3) * damageMultiplier; // Vanilla formula
            if (actualDamage > 0) {
                this.damage(damageSource, actualDamage); // Apply the calculated damage directly
            }
            cir.setReturnValue(true); // Indicate that fall damage has been handled
        } else {
            // Cancel damage if within the safe range
            cir.setReturnValue(false);
        }
    }

    private double getSafeFallDistanceFromEquipment() {
        ItemStack boots = this.getEquippedStack(EquipmentSlot.FEET);
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = boots.getAttributeModifiers(EquipmentSlot.FEET);
        Collection<EntityAttributeModifier> safeFallModifiers = modifiers.get(JuModAttributes.SAFE_FALL_DISTANCE);

        if (!safeFallModifiers.isEmpty()) {
            // Return the first modifier value (could improve for better handling)
            return safeFallModifiers.iterator().next().getValue();
        }
        return 0.0;
    }
}