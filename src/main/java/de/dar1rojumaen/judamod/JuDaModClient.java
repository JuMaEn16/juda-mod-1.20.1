package de.dar1rojumaen.judamod;

import de.dar1rojumaen.judamod.jumaen.item.custom.doubleJump.JuDoubleJumpHandler;
import net.fabricmc.api.ClientModInitializer;

public class JuDaModClient  implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        JuDoubleJumpHandler.register();
    }
}
