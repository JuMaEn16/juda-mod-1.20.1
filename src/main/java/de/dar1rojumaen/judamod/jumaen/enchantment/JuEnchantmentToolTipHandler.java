package de.dar1rojumaen.judamod.jumaen.enchantment;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class JuEnchantmentToolTipHandler {
    public static void register() {
        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            if (stack.hasEnchantments()) {
                var enchantments = EnchantmentHelper.get(stack); // Enchantments korrekt extrahieren
                enchantments.forEach((enchantment, level) -> {
                    // Prüfen, ob die Verzauberung "CLOUD_JUMP" ist
                    if (enchantment == JuModEnchantments.HEATED) {
                        for (int i = 0; i < lines.size(); i++) {
                            Text line = lines.get(i);
                            if (line.getString().contains("Heated")) { // Pass auf den Namen auf
                                lines.set(i, Text.literal("Heated").formatted(Formatting.GOLD)); // Orange Farbe
                            }
                        }
                    }
                });
            }
        });
    }
}