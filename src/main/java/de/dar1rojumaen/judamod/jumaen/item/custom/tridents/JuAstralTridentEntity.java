package de.dar1rojumaen.judamod.jumaen.item.custom.tridents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JuAstralTridentEntity extends TridentEntity {
    public JuAstralTridentEntity(World world, LivingEntity owner, ItemStack stack) {
        super(world, owner, stack);// Use this method to set the trident's stack
    }

    public JuAstralTridentEntity(EntityType<? extends TridentEntity> entityEntityType, World world) {
        super(entityEntityType,world);
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);

        // Pull the target toward the thrower
        if (this.getOwner() instanceof PlayerEntity player) {
            var target = hitResult.getEntity();
            if (target instanceof LivingEntity targetEntity) {
                Vec3d playerPos = player.getPos();
                Vec3d targetPos = targetEntity.getPos();
                Vec3d pullDirection = playerPos.subtract(targetPos).normalize();

                double pullStrength = 1.0; // Adjust pull strength
                targetEntity.addVelocity(pullDirection.x * pullStrength,
                        pullDirection.y * pullStrength,
                        pullDirection.z * pullStrength);

                targetEntity.velocityModified = true; // Sync client and server
            }
        }
    }
}