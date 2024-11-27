package de.dar1rojumaen.judamod.dar1ro.item;

import de.dar1rojumaen.judamod.JuDaMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DaModItems {

    //public static final Item VOIDITE = registerItem("voidite", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JuDaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JuDaMod.LOGGER.info("Registering Dar1ro Mod Items for " + JuDaMod.MOD_ID);
    }
}