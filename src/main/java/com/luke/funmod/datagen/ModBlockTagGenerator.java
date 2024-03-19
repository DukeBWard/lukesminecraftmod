package com.luke.funmod.datagen;

import com.luke.funmod.block.ModBlocks;
import com.luke.funmod.funmod;
import com.luke.funmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, funmod.MODID, existingFileHelper);
    }

    // This will generate the same json file as metal_detector_valuables.json
    // You can use this to replace the below json files minecraft/tags/blocks/mineable and other tags
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_ORE.get(),
                    ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                    ModBlocks.SAPPHIRE_ORE.get(),
                    ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                    ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                    ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                    ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

        // you need these tags for fences and walls for them to connect to eachother
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SAPPHIRE_FENCE.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.EMERALD_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.EMERALD_FENCE_GATE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.EMERALD_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SAPPHIRE_WALL.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.EMERALD_WALL.get());
    }
}
