package de.dar1rojumaen.judamod.jumaen.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class JuHeatedEnchantment extends Enchantment {
    public JuHeatedEnchantment(Enchantment.Rarity weight, EnchantmentTarget type, EquipmentSlot... slots) {
        super(weight, type, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1; // Maximum level for this enchantment
    }

    @Override
    public boolean isTreasure() {
        return false; // If true, only found in treasure loot
    }

    @Override
    public boolean isCursed() {
        return false; // If true, acts like a curse
    }
}
