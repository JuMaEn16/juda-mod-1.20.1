package de.dar1rojumaen.judamod.jumaen.item;

import de.dar1rojumaen.judamod.JuDaMod;
import de.dar1rojumaen.judamod.jumaen.armor.JuModArmorMaterials;
import de.dar1rojumaen.judamod.jumaen.item.custom.doubleJump.JuDoubleJumpBoots;
import de.dar1rojumaen.judamod.jumaen.lodestone.LodestoneDI;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModItems {
    // Create an instance of LodestoneWandItem with appropriate settings
    public static final Item LDI = registerItem("ldi", new LodestoneDI.LodeStoneDI(new Item.Settings()));

    public static final Item VOIDITE = registerItem("voidite", new Item(new FabricItemSettings()));
    public static final Item RAW_VOIDITE = registerItem("raw_voidite", new Item(new FabricItemSettings()));
    public static final Item VOIDITE_BOOTS = registerItem("voidite_boots",
            new JuDoubleJumpBoots(JuModArmorMaterials.VOIDITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JuDaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JuDaMod.LOGGER.info("Registering JuMaEn Mod Items for " + JuDaMod.MOD_ID);
    }
}