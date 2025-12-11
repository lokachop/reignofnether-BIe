package com.solegendary.reignofnether.building.buildings.placements;

import com.solegendary.reignofnether.building.Building;
import com.solegendary.reignofnether.building.BuildingBlock;
import com.solegendary.reignofnether.building.BuildingPlacement;
import com.solegendary.reignofnether.resources.ResourceName;
import com.solegendary.reignofnether.resources.Resources;
import com.solegendary.reignofnether.resources.ResourcesServerEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;

import java.util.ArrayList;

public class ResourcePlacement extends BuildingPlacement {
    public ResourceName getProducingResourceName() {
        return ResourceName.NONE;
    }

    private static final int TICK_RESOURCE_INTERVAL = 20;
    public ResourcePlacement(Building building, Level level, BlockPos originPos, Rotation rotation, String ownerName, ArrayList<BuildingBlock> blocks, boolean isCapitol) {
        super(building, level, originPos, rotation, ownerName, blocks, isCapitol);
    }

    private void tickAddResource() {
        Resources res = new Resources(this.ownerName, 0, 0, 0);

        switch(getProducingResourceName()) {
            case FOOD:
                res.food = 1;
                break;
            case WOOD:
                res.wood = 1;
                break;
            case ORE:
                res.ore = 1;
                break;
        }

        ResourcesServerEvents.addSubtractResources(res);
    }

    @Override
    public void tick(Level tickLevel) {
        super.tick(tickLevel);
        if (!level.isClientSide() && tickAge % TICK_RESOURCE_INTERVAL == 0 && this.isBuilt) {
            tickAddResource();
        }
    }
}
