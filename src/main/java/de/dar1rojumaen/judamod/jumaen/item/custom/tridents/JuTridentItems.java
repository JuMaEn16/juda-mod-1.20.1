package de.dar1rojumaen.judamod.jumaen.item.custom.tridents;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JuTridentItems {
    public static class AstralTrident extends TridentItem {
        public AstralTrident(Settings settings) {
            super(settings);
        }

        @Override
        public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
            if (user instanceof PlayerEntity playerEntity) {
                int charge = this.getMaxUseTime(stack) - remainingUseTicks;

                if (charge >= 10) {
                    if (!world.isClient) {
                        stack.damage(1, playerEntity, (p) -> {
                            p.sendToolBreakStatus(user.getActiveHand());
                        });

                        JuAstralTridentEntity customTrident = new JuAstralTridentEntity(world, playerEntity, stack);
                        customTrident.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F, 1.0F);

                        if (playerEntity.getAbilities().creativeMode) {
                            customTrident.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                        }

                        world.spawnEntity(customTrident);
                        world.playSoundFromEntity(null, customTrident, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);

                        if (!playerEntity.getAbilities().creativeMode) {
                            playerEntity.getInventory().removeOne(stack);
                        }
                    }
                }
            }
        }
    }
}
