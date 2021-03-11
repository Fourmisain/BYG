package corgiaoc.byg.common.world.feature.end.trees.impariusgrove.fungus;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class FungalImparius1 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public FungalImparius1(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.IMPARIUS_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 3, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 3, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 3, 1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 3, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 3, 1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 3, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 3, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 4, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 4, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 4, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 4, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 4, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, 0));
            }
        }
        return true;
    }

    private void imparius_filament(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.FUNGAL_IMPARIUS_FILAMENT.defaultBlockState());
        }
    }

    private void imparius_filament_block(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.defaultBlockState());
        }
    }
}