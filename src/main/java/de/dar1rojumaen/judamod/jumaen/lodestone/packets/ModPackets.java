package de.dar1rojumaen.judamod.jumaen.lodestone.packets;

import de.dar1rojumaen.judamod.JuDaMod;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier PARTICLE_SPAWN_ID = new Identifier(JuDaMod.MOD_ID, "particle_spawn");

    public static void registerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(PARTICLE_SPAWN_ID, (server, player, handler, buf, responseSender) -> {
            ParticleSpawnPacket packet = new ParticleSpawnPacket(buf);
            server.execute(() -> {
                // Server-side handling if needed
            });
        });
    }
}
