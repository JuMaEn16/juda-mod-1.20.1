package de.dar1rojumaen.judamod.helper.datagen;

import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class JuDaModModel extends FabricModelProvider {
    public JuDaModModel(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(JuModItems.VOIDITE, Models.GENERATED);
        itemModelGenerator.register(JuModItems.RAW_VOIDITE, Models.GENERATED);
        itemModelGenerator.register(JuModItems.VOIDITE_BOOTS, Models.GENERATED);
    }
}
