package com.luke.funmod.datagen;

import com.luke.funmod.funmod;
import com.luke.funmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, funmod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SAPPHIRE_HELMET.get(),
                    ModItems.SAPPHIRE_CHESTPLATE.get(),
                    ModItems.SAPPHIRE_LEGGINGS.get(),
                    ModItems.SAPPHIRE_BOOTS.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMERALD_HELMET.get(),
                        ModItems.EMERALD_CHESTPLATE.get(),
                        ModItems.EMERALD_LEGGINGS.get(),
                        ModItems.EMERALD_BOOTS.get());
    }
}
