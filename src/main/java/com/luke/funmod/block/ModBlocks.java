package com.luke.funmod.block;

import com.luke.funmod.block.custom.SoundBlock;
import com.luke.funmod.funmod;
import com.luke.funmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block>  BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, funmod.MODID);


    // This is cool, you can override some properties such as sound
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    // DropExperienceBlock is to drop experience and block
    // UniformInt is a range of numbers for amount of exp gained, forge exclusive
    // satisfies IntProvider from DropExperienceBlock
    // Strength is arbitrary number for time to break the block
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(1f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_STAIRS = registerBlock("sapphire_stairs",
            () -> new StairBlock(() ->  ModBlocks.SAPPHIRE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> EMERALD_STAIRS = registerBlock("emerald_stairs",
            () -> new StairBlock(() -> Blocks.EMERALD_BLOCK.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_SLAB = registerBlock("sapphire_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> EMERALD_SLAB = registerBlock("emerald_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_BUTTON = registerBlock("sapphire_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> EMERALD_BUTTON = registerBlock("emerald_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> EMERALD_PRESSURE_PLATE = registerBlock("emerald_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> SAPPHIRE_FENCE = registerBlock("sapphire_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> EMERALD_FENCE = registerBlock("emerald_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> EMERALD_FENCE_GATE = registerBlock("emerald_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK),
                    SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> SAPPHIRE_WALL = registerBlock("sapphire_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> EMERALD_WALL = registerBlock("emerald_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    //no occlusion is needed for doors with cutouts
    public static final RegistryObject<Block> SAPPHIRE_DOOR = registerBlock("sapphire_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.IRON));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        // The lambda: () -> new BlockItem(block.get(), new Item.Properties()) represents a supplier
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) 
    {
        BLOCKS.register(eventBus);
    }
}
