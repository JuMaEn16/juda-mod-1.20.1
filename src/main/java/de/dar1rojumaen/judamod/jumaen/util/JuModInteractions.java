package de.dar1rojumaen.judamod.jumaen.util;

import de.dar1rojumaen.judamod.jumaen.enchantment.JuModEnchantments;
import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import java.util.Map;

public class JuModInteractions {
    public static void register() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            // Check if we are on the server side
            if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
                return onRightClickBlock(serverPlayer, world, hand, hitResult);
            }
            return ActionResult.PASS; // Let other interactions proceed
        });
    }

    private static ActionResult onRightClickBlock(ServerPlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        // Ensure we are on the server side
        if (!world.isClient) {
            ItemStack stack = player.getStackInHand(hand);

            // Check if the player is holding the item and the block is a lava cauldron
            if (stack.isOf(JuModItems.HELLFORK_TRIDENT) && isLavaCauldron(world, hitResult)) {
                // Apply the "Heated" enchantment
                if (!EnchantmentHelper.get(stack).containsKey(JuModEnchantments.HEATED)) {
                    stack.addEnchantment(JuModEnchantments.HEATED, 1); // Add enchantment
                    player.sendMessage(Text.literal("Your Trident is now Heated!").formatted(Formatting.GOLD), true);
                    world.setBlockState(hitResult.getBlockPos(), Blocks.CAULDRON.getDefaultState());
                    // Optionally, reduce durability or play a sound
                    stack.damage(5, player, p -> p.sendToolBreakStatus(hand));
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.literal("Your Trident is already Heated!").formatted(Formatting.RED), true);
                }
            } else if (stack.isOf(JuModItems.HELLFORK_TRIDENT) && isWaterPowderedSnowCauldron(world, hitResult)) {
                // Check if the trident has the "Heated" enchantment
                if (EnchantmentHelper.get(stack).containsKey(JuModEnchantments.HEATED)) {
                    // Remove the "Heated" enchantment
                    removeEnchantment(stack, JuModEnchantments.HEATED);
                    player.sendMessage(Text.literal("Your Trident is now cool again!").formatted(Formatting.AQUA), true);
                    world.setBlockState(hitResult.getBlockPos(), Blocks.CAULDRON.getDefaultState());
                    // Optionally, play a sound or effect
                    stack.damage(3, player, p -> p.sendToolBreakStatus(hand));
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.literal("Your Trident is already cool!").formatted(Formatting.GRAY), true);
                }
            }
        }

        return ActionResult.PASS; // Allow other interactions to proceed
    }

    private static boolean isLavaCauldron(World world, BlockHitResult hitResult) {
        return world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.LAVA_CAULDRON);
    }
    private static boolean isWaterPowderedSnowCauldron(World world, BlockHitResult hitResult) {
        return world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.WATER_CAULDRON) || world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.POWDER_SNOW_CAULDRON);
    }

    // Helper method to remove an enchantment from an ItemStack
    private static void removeEnchantment(ItemStack stack, Enchantment enchantment) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(stack);

        // Remove the specified enchantment
        if (enchantments.containsKey(enchantment)) {
            enchantments.remove(enchantment);

            // Reapply the remaining enchantments to the stack
            EnchantmentHelper.set(enchantments, stack);
        }
    }
}
