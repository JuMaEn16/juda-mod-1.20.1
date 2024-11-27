package de.dar1rojumaen.judamod.dar1ro.inventoryGroup;

import de.dar1rojumaen.judamod.JuDaMod;
import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DaModGeneralGroup {
    //public static final ItemGroup VOIDITE_GROUP = Registry.register(Registries.ITEM_GROUP,
    //        new Identifier(JuDaMod.MOD_ID, "voidite"),
    //        FabricItemGroup.builder().displayName(Text.translatable("judamod.itemgroup.voidite"))
    //                .icon(() -> new ItemStack(JuModItems.VOIDITE)).entries((displayContext, entries) -> {
    //                    entries.add(JuModItems.VOIDITE);
    //                }).build());


    public static void registerItemGroups() {
        JuDaMod.LOGGER.info("Registering Dar1ro Item Groups for " + JuDaMod.MOD_ID);
    }
}
