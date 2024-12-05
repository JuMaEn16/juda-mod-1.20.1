package de.dar1rojumaen.judamod.mixin;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LoyaltyEnchantment.class)
public abstract class LoyaltyEnchantmentMixin extends Enchantment {
    protected LoyaltyEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slots) {
        super(weight, type, slots);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        // Erlaube Riptide zusätzlich zu den bestehenden Regeln
        return super.canAccept(other) || other == Enchantments.RIPTIDE;
    }
}
