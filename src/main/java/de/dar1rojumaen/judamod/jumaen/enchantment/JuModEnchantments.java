package de.dar1rojumaen.judamod.jumaen.enchantment;

import de.dar1rojumaen.judamod.JuDaMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

public class JuModEnchantments {
    public static final Enchantment CLOUD_JUMP = new JuCloudJumpEnchantment(
            Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, EquipmentSlot.FEET
    );
    public static final Enchantment HEATED = new JuCloudJumpEnchantment(
            Enchantment.Rarity.UNCOMMON, EnchantmentTarget.TRIDENT,
            EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND);

    public static void register() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(JuDaMod.MOD_ID, "cloud_jump"), CLOUD_JUMP);
        Registry.register(Registries.ENCHANTMENT, new Identifier(JuDaMod.MOD_ID, "heated"), HEATED);
        JuDaMod.LOGGER.info("Registered custom enchantments for " + JuDaMod.MOD_ID);
    }
}
