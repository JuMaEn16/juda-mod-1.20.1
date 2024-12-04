package de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral;

import de.dar1rojumaen.judamod.JuDaMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class JuAstralTridentModel extends EntityModel<Entity> {
	public static final Identifier TEXTURE = new Identifier(JuDaMod.MOD_ID,"textures/entity/astral_trident.png");
	private final ModelPart bb_main;
	public JuAstralTridentModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(8, 5).cuboid(-1.0F, -22.0F, -3.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(-1.0F, -22.0F, 1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(-1.0F, -19.0F, -2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 10).cuboid(-1.0F, -19.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 0).cuboid(-1.0F, -23.0F, -1.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(-1.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -4.0F, 0.5F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}