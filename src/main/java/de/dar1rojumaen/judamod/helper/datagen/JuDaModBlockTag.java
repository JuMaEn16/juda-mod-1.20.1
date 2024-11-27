package de.dar1rojumaen.judamod.helper.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JuDaModBlockTag extends FabricTagProvider.BlockTagProvider {
    public JuDaModBlockTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
        //        .add(ModBlocks.RUBY_ORE)
        //        .forceAddTag(BlockTags.GOLD_ORES);
        //
        //getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        //        .add(ModBlocks.RAW_RUBY_BLOCK);
        //
        //getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        //        .add(ModBlocks.RUBY_BLOCK);
        //
        //getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        //        .add(ModBlocks.RAW_RUBY_BLOCK)
        //        .add(ModBlocks.RUBY_ORE);
        //
        //getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        //        .add(ModBlocks.DEEPSLATE_RUBY_ORE);
        //
        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        //        .add(ModBlocks.END_STONE_RUBY_ORE);
    }
}