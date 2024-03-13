package com.kevinthegreat.skyblockmod.dungeons;

import com.kevinthegreat.skyblockmod.SkyblockMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.map.MapState;

//from skyfabric
public class DungeonMap {
    public boolean on = true;
    public float scale = 1;
    public int offsetX = 0;
    public int offsetY = 0;

    public void render(MatrixStack matrixStack, float tickDelta) {
        if (on && SkyblockMod.skyblockMod.util.catacombs) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            if (minecraftClient == null || minecraftClient.player == null || minecraftClient.world == null) {
                return;
            }
            MapState mapState = FilledMapItem.getMapState(1024, minecraftClient.world);
            if (mapState == null) {
                return;
            }
            VertexConsumerProvider.Immediate vertices = minecraftClient.getBufferBuilders().getEffectVertexConsumers();
            matrixStack.push();
            matrixStack.translate(offsetX, offsetY, 0);
            matrixStack.scale(scale, scale, 0);
            minecraftClient.gameRenderer.getMapRenderer().draw(matrixStack, vertices, 1024, mapState, false, 15728880);
            vertices.draw();
            matrixStack.pop();
        }
    }
}
