package com.dp.builder;

public class ComplexTerrainBuilder implements TerrainBuilder {
    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder builderWall() {
        terrain.w = new Wall(10,9,8,7);
        return this;
    }

    @Override
    public TerrainBuilder builderFort() {
        terrain.f = new Fort(5,6,7,8);
        return this;
    }

    @Override
    public TerrainBuilder builderMine() {
        terrain.m = new Mine(4,5,6,7);
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
