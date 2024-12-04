package de.dar1rojumaen.judamod;

import de.dar1rojumaen.judamod.jumaen.entities.JuModEntities;
import de.dar1rojumaen.judamod.jumaen.item.custom.doubleJump.JuDoubleJumpHandler;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral.JuAstralTridentRenderer;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral.JuAstraTridentModelLayers;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.hellfork.JuHellForkTridentModelLayers;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.hellfork.JuHellForkTridentRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class JuDaModClient  implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        JuDoubleJumpHandler.register();
        //ModClientPackets.registerClientPackets();

        JuAstraTridentModelLayers.registerModelLayers();

        EntityRendererRegistry.register(
                JuModEntities.ASTRAL_TRIDENT_ENTITY, // Your custom entity type
                JuAstralTridentRenderer::new
        );

        JuHellForkTridentModelLayers.registerModelLayers();

        EntityRendererRegistry.register(
                JuModEntities.HELLFORK_TRIDENT_ENTITY, // Your custom entity type
                JuHellForkTridentRenderer::new
        );
    }
}
