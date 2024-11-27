package de.dar1rojumaen.judamod.jumaen.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class JuCloudJumpEnchantment extends Enchantment {
    public JuCloudJumpEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slots) {
        super(weight, type, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3; // Maximum level for this enchantment
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
