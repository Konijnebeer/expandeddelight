package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.AsparagusCropBlock;
import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.nhoryzon.mc.farmersdelight.block.WildPatchBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static final Block ASPARAGUS_CRATE = block("asparagus_crate",
            new Block(blockSettings(Material.WOOD, 2.0f, 3.0f, BlockSoundGroup.WOOD)));
    public static final Block WILD_ASPARAGUS = block("wild_asparagus", new WildPatchBlock());
    public static final Block ASPARAGUS_CROP = withoutBlockItem("asparagus_crop", new AsparagusCropBlock(cropSettings()));

    public static void registerRenderLayer() {
        renderLayer(WILD_ASPARAGUS, RenderLayer.getCutout());
        renderLayer(ASPARAGUS_CROP, RenderLayer.getCutout());
    }

    private static FabricBlockSettings blockSettings(Material material, float hardness, float resistance, BlockSoundGroup sound) {
        return FabricBlockSettings.of(material).hardness(hardness).resistance(resistance).sounds(sound);
    }

    private static FabricBlockSettings cropSettings() {
        return FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.CROP).breakInstantly().ticksRandomly().noCollision().nonOpaque();
    }

    private static Block block(String name, Block block) {
        blockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ExpandedDelight.MOD_ID, name), block);
    }

    private static Item blockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP)));
    }

    private static Block withoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ExpandedDelight.MOD_ID, name), block);
    }

    private static void renderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }

    public static void registerBlocks() {
        ExpandedDelight.LOGGER.info("Registering blocks for Expanded Delight!");
    }
}
