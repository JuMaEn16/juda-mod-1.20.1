package de.dar1rojumaen.judamod.jumaen.item.custom.tridents;

import de.dar1rojumaen.judamod.jumaen.entities.JuModEntities;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral.JuAstralTridentEntity;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.hellfork.JuHellForkTridentEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JuTridentItems {
    public static class AstralTrident extends TridentItem {
        public AstralTrident(Settings settings) {
            super(settings);
        }

        @Override
        public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
            if (!world.isClient) {
                if (user instanceof PlayerEntity) {
                    int i = this.getMaxUseTime(stack) - remainingUseTicks;
                    if (i >= 10) {
                        PlayerEntity player = (PlayerEntity) user;
                        stack.damage(1, player, p -> p.sendToolBreakStatus(user.getActiveHand()));
                        System.out.println("Astral Trident pull");

                        JuAstralTridentEntity tridentEntity = new JuAstralTridentEntity(world, user, stack);
                        tridentEntity.setPos(user.getX(), user.getEyeY() - 0.1, user.getZ()); // Adjust for hand position if necessary
                        tridentEntity.setOwner(user);
                        tridentEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
                        world.spawnEntity(tridentEntity);

                        System.out.println(tridentEntity);

                        System.out.println("Astral Trident pull 2");

                        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                                SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);

                        if (!player.getAbilities().creativeMode) {
                            player.getInventory().removeOne(stack);
                        }
                    }
                }
            }
        }
    }

    public static class HellFork extends TridentItem {
        public HellFork(Settings settings) {
            super(settings);
        }

        @Override
        public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
            if (user instanceof PlayerEntity player) {
                int useDuration = this.getMaxUseTime(stack) - remainingUseTicks;
                // Überprüfen, ob der Spieler den Trident lange genug aufgeladen hat
                if (useDuration >= 10) {
                    int riptideLevel = EnchantmentHelper.getRiptide(stack);
                    // Überprüfen, ob der Trident Riptide hat und ob die Bedingungen erfüllt sind
                    if (isFireOrLava(player) && riptideLevel > 0 ) {
                        float yaw = player.getYaw();
                        float pitch = player.getPitch();

                        // Richtung berechnen (h: X, k: Y, l: Z)
                        float directionX = -MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
                        float directionY = -MathHelper.sin(pitch * (float) (Math.PI / 180.0));
                        float directionZ = MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));

                        // Richtung normalisieren und skalieren
                        float directionMagnitude = MathHelper.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
                        float velocityScale = 3.0F * ((1.0F + (float) riptideLevel) / 4.0F);
                        directionX *= velocityScale / directionMagnitude;
                        directionY *= velocityScale / directionMagnitude;
                        directionZ *= velocityScale / directionMagnitude;

                        // Spieler bewegen
                        player.addVelocity(directionX, directionY, directionZ);
                        player.useRiptide(20);

                        // Spieler leicht nach oben bewegen, wenn er am Boden ist
                        if (player.isOnGround()) {
                            player.move(MovementType.SELF, new Vec3d(0.0, 1.1999999F, 0.0));
                        }

                        // Riptide-Sound abspielen
                        SoundEvent soundEvent;
                        if (riptideLevel >= 3) {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
                        } else if (riptideLevel == 2) {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
                        } else {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
                        }

                        world.playSoundFromEntity(null, player, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    } else {
                        // Standard-Wurf ohne Riptide
                        if (!world.isClient) {
                            stack.damage(1, player, p -> p.sendToolBreakStatus(user.getActiveHand()));

                            // Trident als Projektil werfen
                            JuHellForkTridentEntity tridentEntity = new JuHellForkTridentEntity(world, player, stack);
                            tridentEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);
                            if (player.getAbilities().creativeMode) {
                                tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                            }

                            world.spawnEntity(tridentEntity);
                            world.playSoundFromEntity(null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            if (!player.getAbilities().creativeMode) {
                                player.getInventory().removeOne(stack);
                            }
                        }
                    }
                }
            }
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
                return TypedActionResult.fail(itemStack);
            } else {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            }
        }

        public boolean isFireOrLava(LivingEntity user) {
            return user.isOnFire() || user.isInLava();
        }
    }
}
