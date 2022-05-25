package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.block.entity.CoolerBlockEntity;
import com.ianm1647.expandeddelight.block.entity.JuicerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {
    public static BlockEntityType<CoolerBlockEntity> COOLER;
    public static BlockEntityType<JuicerBlockEntity> JUICER;

    public static void registerBlockEntity() {
        COOLER = entity("cooler", CoolerBlockEntity::new, BlockList.COOLER);
        JUICER = entity("juicer", JuicerBlockEntity::new, BlockList.JUICER);
    }

    private static BlockEntityType entity(String name, Factory<? extends BlockEntity> entity, Block block) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ExpandedDelight.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(entity, block).build(null));
    }
}
