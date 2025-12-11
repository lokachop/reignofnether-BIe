package com.solegendary.reignofnether.building.resource;

import com.solegendary.reignofnether.building.Building;
import com.solegendary.reignofnether.building.BuildingPlacement;
import com.solegendary.reignofnether.resources.ResourceCost;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;

import static com.solegendary.reignofnether.building.BuildingUtils.getAbsoluteBlockData;

public abstract class ResourceBuilding extends Building {
    public ResourceBuilding(String structureName, ResourceCost cost, boolean isCapitol) {
        super(structureName, cost, isCapitol);
    }
}
