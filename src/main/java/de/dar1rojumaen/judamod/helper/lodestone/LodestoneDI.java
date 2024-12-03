package de.dar1rojumaen.judamod.helper.lodestone;

import de.dar1rojumaen.judamod.dar1ro.sound.DaModSounds;
import de.dar1rojumaen.judamod.helper.lodestone.packets.ModPackets;
import de.dar1rojumaen.judamod.helper.lodestone.packets.ParticleSpawnPacket;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.awt.*;

public class LodestoneDI {
    public static class LodeStoneDI extends Item {

        public LodeStoneDI(Settings settings) {
            super(settings);
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
            World world = context.getWorld();
            PlayerEntity player = context.getPlayer();
            BlockPos blockPos = context.getBlockPos();
            Hand hand =context.getHand();

            if (!world.isClient() && player != null) {

                Vec3d orginalPos = Vec3d.ofCenter(blockPos);


                Color startingColor = new Color(100, 0, 100);
                Color endingColor = new Color(0, 100, 200);
                ParticleSpawnPacket packet = new ParticleSpawnPacket(orginalPos, startingColor.getRGB(), endingColor.getRGB());
                player.playSound(DaModSounds.DOUBLE_JUMP, SoundCategory.PLAYERS, 1.0F, 1.0F);

                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                packet.toBytes(buf);

                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                if (serverPlayer != null) {
                    ServerPlayNetworking.send(serverPlayer, ModPackets.PARTICLE_SPAWN_ID, buf);
                    serverPlayer.sendMessage(Text.of("Particle has spawned"), true);
                }
                return ActionResult.SUCCESS;

            }
            return ActionResult.PASS;

        }

    }
}
