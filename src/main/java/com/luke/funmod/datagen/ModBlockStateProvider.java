package com.luke.funmod.datagen;

import com.luke.funmod.block.ModBlocks;
import com.luke.funmod.funmod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, funmod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        stairsBlock(((StairBlock) ModBlocks.EMERALD_STAIRS.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        slabBlock(((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.EMERALD_SLAB.get()),
                blockTexture(Blocks.EMERALD_BLOCK),
                blockTexture(Blocks.EMERALD_BLOCK));

        buttonBlock(((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.EMERALD_BUTTON.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.EMERALD_PRESSURE_PLATE.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        fenceBlock(((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.EMERALD_FENCE.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        fenceGateBlock(((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.EMERALD_FENCE_GATE.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        wallBlock(((WallBlock) ModBlocks.SAPPHIRE_WALL.get()),
                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.EMERALD_WALL.get()),
                blockTexture(Blocks.EMERALD_BLOCK));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get()),
                modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get()),
                modLoc("block/sapphire_trapdoor"), true, "cutout");
    }

    // This makes the custom block AND item that goes with it
    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
