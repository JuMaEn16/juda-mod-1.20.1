package de.dar1rojumaen.judamod.jumaen.item.custom.tridents.hellfork;

import de.dar1rojumaen.judamod.JuDaMod;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class JuHellForkTridentModelLayers {
    public static final EntityModelLayer HELL_TRIDENT_LAYER = new EntityModelLayer(
            new Identifier(JuDaMod.MOD_ID, "hell_trident"), "main"
    );

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(HELL_TRIDENT_LAYER, JuHellForkTridentModel::getTexturedModelData);
    }
}
