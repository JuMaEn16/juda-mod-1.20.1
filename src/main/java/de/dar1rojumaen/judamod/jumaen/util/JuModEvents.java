package de.dar1rojumaen.judamod.jumaen.util;

import de.dar1rojumaen.judamod.jumaen.enchantment.JuModEnchantments;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class JuModEvents {
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(JuModEvents::onTick);
    }

    private static void onTick(World world) {
        // Überprüfen, ob die Welt ein Server ist
        if (!world.isClient) {
            for (PlayerEntity player : world.getPlayers()) {
                // Check Mainhand/Offhand
                ItemStack mainHand = player.getMainHandStack();
                ItemStack offHand = player.getOffHandStack();

                // Überprüfen, ob der Spieler das verzauberte Item hält
                if (isHoldingHeated(mainHand) || isHoldingHeated(offHand)) {
                    if (player.getFireTicks() < 10) {
                        player.setFireTicks(10); // Setzt den FireTick auf 10
                    }
                }
            }
        }
    }

    private static boolean isHoldingHeated(ItemStack stack) {
        // Überprüfen, ob das Item verzaubert ist und die richtige Verzauberung hat
        return stack.hasEnchantments() && EnchantmentHelper.getLevel(JuModEnchantments.HEATED, stack) > 0;
    }
}

