package de.dar1rojumaen.judamod.jumaen.armor;

import de.dar1rojumaen.judamod.helper.armor.JuDaCustomArmorMaterial;
import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;

import java.util.EnumMap;

public class JuModArmorMaterials {
    public static final ArmorMaterial VOIDITE_ARMOR_MATERIAL = new JuDaCustomArmorMaterial(
            "voidite",
            new EnumMap<>(EquipmentSlot.class) {{
                put(EquipmentSlot.FEET, 3);
                put(EquipmentSlot.LEGS, 4);
                put(EquipmentSlot.CHEST, 5);
                put(EquipmentSlot.HEAD, 2);
            }},
            22, // Durability multiplier
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, // Equip sound
            Ingredient.ofItems(JuModItems.VOIDITE), // Repair material
            2.0F, // Toughness
            1.0F  // Knockback resistance
    );
}

