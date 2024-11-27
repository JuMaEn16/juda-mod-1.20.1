package de.dar1rojumaen.judamod.helper.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.Map;

public class JuDaCustomArmorMaterial implements ArmorMaterial {
    private final String name;
    private final Map<EquipmentSlot, Integer> protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;
    private final float toughness;
    private final float knockbackResistance;

    public JuDaCustomArmorMaterial(
            String name,
            Map<EquipmentSlot, Integer> protectionAmounts,
            int enchantability,
            SoundEvent equipSound,
            Ingredient repairIngredient,
            float toughness,
            float knockbackResistance) {
        this.name = name;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        // Base durability multipliers for each type
        int baseDurability = switch (type) {
            case BOOTS -> 13;
            case LEGGINGS -> 15;
            case CHESTPLATE -> 16;
            case HELMET -> 11;
        };
        return baseDurability * 3; // Adjust this multiplier as needed
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts.getOrDefault(type, 0);
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}