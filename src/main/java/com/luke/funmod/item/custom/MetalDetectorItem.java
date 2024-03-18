package com.luke.funmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        // this is checking the server, not clientside
        // somewhat confusing, but this is checking if this is on the logical server or logical client
        // we mostly want things to only be on the logical server, as that is what typically
        // handles the in game logic.  logical client is what accepts player input and relays it to
        // the logical server.  it also receives info from logical server and displays graphics for player
        if(!pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++)
            {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                
                if (isValuableBlock(state))
                {
                    outputValuableCoordinates(positionClicked.below(),player,state.getBlock());
                    foundBlock = true;

                    break;
                }
                
            }
            if (!foundBlock)
            {
                player.sendSystemMessage(Component.literal("No valuables found"));
            }

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        // system message is chat
        // I18n is for language translation
        // component is a chat item
        // literal components cannot translate, translatable components can
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE);
    }
}
