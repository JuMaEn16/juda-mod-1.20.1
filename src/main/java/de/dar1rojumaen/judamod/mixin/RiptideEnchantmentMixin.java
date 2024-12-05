package de.dar1rojumaen.judamod.mixin;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RiptideEnchantment.class)
public abstract class RiptideEnchantmentMixin extends Enchantment {
    protected RiptideEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slots) {
        super(weight, type, slots);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        // Erlaube Loyalty und Channeling zusätzlich zu den bestehenden Regeln
        return super.canAccept(other) || other == Enchantments.LOYALTY || other == Enchantments.CHANNELING;
    }
}

