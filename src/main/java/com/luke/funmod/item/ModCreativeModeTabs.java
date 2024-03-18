package com.luke.funmod.item;

import net.minecraft.network.chat.Component;

import com.luke.funmod.funmod;
import com.luke.funmod.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, funmod.MODID);

    public static final RegistryObject<CreativeModeTab> FUN_TAB = CREATIVE_MODE_TABS.register("fun_tab",
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
        .title(Component.translatable("creativetab.fun_mod"))
        .displayItems((pParameters, pOutput) -> {
            pOutput.accept(ModItems.SAPPHIRE.get());
            pOutput.accept(ModItems.RAW_SAPPHIRE.get());
            pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
            pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

            pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
        })
        .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
