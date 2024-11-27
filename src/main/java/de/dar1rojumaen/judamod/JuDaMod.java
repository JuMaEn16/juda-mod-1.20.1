package de.dar1rojumaen.judamod;

import de.dar1rojumaen.judamod.dar1ro.inventoryGroup.DaModGeneralGroup;
import de.dar1rojumaen.judamod.dar1ro.item.DaModItems;
import de.dar1rojumaen.judamod.jumaen.attribute.JuModAttributes;
import de.dar1rojumaen.judamod.jumaen.enchantment.JuModEnchantments;
import de.dar1rojumaen.judamod.jumaen.inventoryGroup.JuModGeneralGroup;
import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuDaMod implements ModInitializer {
	public static final String MOD_ID = "juda-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//Dar1ro
		DaModItems.registerModItems();
		DaModGeneralGroup.registerItemGroups();

		//JuMaEn
		JuModItems.registerModItems();
		JuModGeneralGroup.registerItemGroups();

		JuModEnchantments.register();

		JuModAttributes.register();


		LOGGER.info("Hello Fabric world!");
	}
}