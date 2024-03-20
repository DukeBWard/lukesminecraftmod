package com.luke.funmod.item;

import com.luke.funmod.funmod;
import com.luke.funmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            // 4 is netherite, 5 is above
            // the list is to list tiers that are better then worse than the new tier
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
                    new ResourceLocation(funmod.MODID, "sapphire"), List.of(Tiers.NETHERITE), List.of()
    );

    public static final Tier EMERALD = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(Items.EMERALD)),
            new ResourceLocation(funmod.MODID, "emerald"), List.of(Tiers.NETHERITE), List.of()
    );



}
