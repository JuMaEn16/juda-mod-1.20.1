package de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral;

import de.dar1rojumaen.judamod.JuDaMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class JuAstralTridentRenderer extends EntityRenderer<JuAstralTridentEntity> {
    private static final Identifier TRIDENT_EMISSIVE_TEXTURE = new Identifier(JuDaMod.MOD_ID, "textures/entity/astral_trident_emissive.png");
    private final JuAstralTridentModel model;

    public JuAstralTridentRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new JuAstralTridentModel(context.getPart(JuAstraTridentModelLayers.ASTRAL_TRIDENT_LAYER));
    }

    @Override
    public Identifier getTexture(JuAstralTridentEntity entity) {
        return JuAstralTridentModel.TEXTURE; // Use your custom texture
    }

    @Override
    public void render(JuAstralTridentEntity tridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, tridentEntity.prevYaw, tridentEntity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, tridentEntity.prevPitch, tridentEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(
                vertexConsumers, this.model.getLayer(this.getTexture(tridentEntity)), false, tridentEntity.isEnchanted()
        );
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        // Render the emissive texture
        VertexConsumer emissiveVertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEyes(TRIDENT_EMISSIVE_TEXTURE));
        this.model.render(matrixStack, emissiveVertexConsumer, 15728880, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
        super.render(tridentEntity, f, g, matrixStack, vertexConsumers, i);
    }
}
