package com.dp.builder;

public interface TerrainBuilder {
    TerrainBuilder builderWall();
    TerrainBuilder builderFort();
    TerrainBuilder builderMine();
    Terrain build();
}
