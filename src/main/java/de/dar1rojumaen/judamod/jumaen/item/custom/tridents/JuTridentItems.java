package de.dar1rojumaen.judamod.jumaen.item.custom.tridents;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Vec3d;

public class JuTridentItems {
    public static class AstralTrident extends TridentItem {
        public AstralTrident(Settings settings) {
            super(settings);
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            stack.damage(1, attacker, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });

            // Calculate pull direction (from target to attacker)
            Vec3d attackerPos = attacker.getPos();
            Vec3d targetPos = target.getPos();
            Vec3d pullDirection = attackerPos.subtract(targetPos).normalize();

            // Apply pull force to the target
            double pullStrength = 1.0; // Adjust strength
            target.addVelocity(pullDirection.x * pullStrength,
                    pullDirection.y * pullStrength,
                    pullDirection.z * pullStrength);

            target.velocityModified = true;
            return true;
        }
    }
}
