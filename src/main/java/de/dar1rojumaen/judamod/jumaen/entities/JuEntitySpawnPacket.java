package de.dar1rojumaen.judamod.jumaen.entities;

import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral.JuAstralTridentEntity;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;

public class JuEntitySpawnPacket {

    public static Packet<ClientPlayPacketListener> create(JuAstralTridentEntity entity, Identifier packetId) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeVarInt(entity.getId()); // Entity ID
        buf.writeUuid(entity.getUuid()); // Entity UUID
        buf.writeDouble(entity.getX()); // Entity X position
        buf.writeDouble(entity.getY()); // Entity Y position
        buf.writeDouble(entity.getZ()); // Entity Z position
        buf.writeFloat(entity.getPitch()); // Entity pitch
        buf.writeFloat(entity.getYaw()); // Entity yaw
        return ServerPlayNetworking.createS2CPacket(packetId, buf);
    }
}