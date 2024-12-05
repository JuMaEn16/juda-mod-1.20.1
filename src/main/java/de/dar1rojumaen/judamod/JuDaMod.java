package de.dar1rojumaen.judamod;

import de.dar1rojumaen.judamod.dar1ro.inventoryGroup.DaModGeneralGroup;
import de.dar1rojumaen.judamod.dar1ro.item.DaModItems;
import de.dar1rojumaen.judamod.dar1ro.sound.DaModSounds;
import de.dar1rojumaen.judamod.jumaen.attribute.JuModAttributes;
import de.dar1rojumaen.judamod.jumaen.enchantment.JuEnchantmentToolTipHandler;
import de.dar1rojumaen.judamod.jumaen.enchantment.JuModEnchantments;
import de.dar1rojumaen.judamod.jumaen.entities.JuModEntities;
import de.dar1rojumaen.judamod.jumaen.inventoryGroup.JuModGeneralGroup;
import de.dar1rojumaen.judamod.jumaen.item.JuModItems;
//import de.dar1rojumaen.judamod.helper.lodestone.packets.ModClientPackets;
//import de.dar1rojumaen.judamod.helper.lodestone.packets.ModPackets;
import de.dar1rojumaen.judamod.jumaen.util.JuModEvents;
import de.dar1rojumaen.judamod.jumaen.util.JuModInteractions;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuDaMod implements ModInitializer {
	public static final String MOD_ID = "juda-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//TO DO
	//
	//JUMAEN
	//Bei Trident Riptide und Loyality erlauben (Custom Enchantment?)

	@Override
	public void onInitialize() {

		//Dar1ro
		DaModItems.registerModItems();
		DaModGeneralGroup.registerItemGroups();

		DaModSounds.registerSounds();

		//JuMaEn
		JuModItems.registerModItems();
		JuModGeneralGroup.registerItemGroups();

		JuModEnchantments.register();
		JuEnchantmentToolTipHandler.register();

		JuModAttributes.register();
		JuModEvents.register();
		JuModInteractions.register();

		JuModEntities.register();

		//ModPackets.registerPackets();

		LOGGER.info("Hello Fabric world!");
	}
}