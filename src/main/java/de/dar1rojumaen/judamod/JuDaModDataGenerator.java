package de.dar1rojumaen.judamod;

import de.dar1rojumaen.judamod.helper.datagen.*;
import de.dar1rojumaen.judamod.jumaen.enchantment.JuModEnchantments;
import de.dar1rojumaen.judamod.jumaen.item.custom.doubleJump.JuDoubleJumpHandler;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JuDaModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(JuDaModBlockTag::new);
		pack.addProvider(JuDaModItemTag::new);
		pack.addProvider(JuDaModLootTable::new);
		pack.addProvider(JuDaModModel::new);
		pack.addProvider(JuDaModRecipe::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		//registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, JuModEnchantments::bootstrap);
	}
}
