package de.dar1rojumaen.judamod.helper.attributes;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import de.dar1rojumaen.judamod.jumaen.attribute.JuModAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collection;

public class JuDaSafeFallAttributeHandler extends PlayerEntity {
    public JuDaSafeFallAttributeHandler(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        // Get the safe fall distance value from equipment or attributes
        double safeFallDistance = getSafeFallDistanceFromEquipment();

        if (fallDistance > safeFallDistance) {
            float adjustedFallDistance = (float) (fallDistance - safeFallDistance);
            return super.handleFallDamage(adjustedFallDistance, damageMultiplier, damageSource); // Apply reduced damage
        } else {
            return false; // No fall damage taken
        }
    }

    @Override
    public boolean isSpectator() {
        return false;
    }
    @Override
    public boolean isCreative() {
        return false;
    }

    private double getSafeFallDistanceFromEquipment() {
        ItemStack boots = this.getEquippedStack(EquipmentSlot.FEET); // Assuming "this" is a LivingEntity

        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = boots.getAttributeModifiers(EquipmentSlot.FEET);
        Collection<EntityAttributeModifier> safeFallModifiers = modifiers.get(JuModAttributes.SAFE_FALL_DISTANCE);
        if (!safeFallModifiers.isEmpty()) {
            // Assuming there’s only one modifier for this attribute
            return safeFallModifiers.iterator().next().getValue();
        }

        return 0.0; // Default safe fall distance if no attribute is present
    }
}