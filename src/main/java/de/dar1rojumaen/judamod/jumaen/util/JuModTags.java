package de.dar1rojumaen.judamod.jumaen.util;

import de.dar1rojumaen.judamod.JuDaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class JuModTags {
    public static class Blocks {
        //public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
        //        createTag("metal_detector_detectable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(JuDaMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> VOIDITE_ITEMS =
                createTag("voidite_items");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(JuDaMod.MOD_ID, name));
        }
    }
}
