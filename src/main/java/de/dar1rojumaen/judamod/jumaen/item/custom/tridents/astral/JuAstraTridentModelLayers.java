package de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral;

import de.dar1rojumaen.judamod.JuDaMod;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class JuAstraTridentModelLayers {
    public static final EntityModelLayer ASTRAL_TRIDENT_LAYER = new EntityModelLayer(
            new Identifier(JuDaMod.MOD_ID, "astral_trident"), "main"
    );

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(ASTRAL_TRIDENT_LAYER, JuAstralTridentModel::getTexturedModelData);
    }
}
