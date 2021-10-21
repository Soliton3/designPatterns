package com.dp.builder;

public class Terrain {
    Wall w;
    Fort f;
    Mine m;

    public Terrain(){}
    public Terrain(Wall w, Fort f, Mine m) {
        this.w = w;
        this.f = f;
        this.m = m;
    }
}

class Wall{
    int x , y , w , v;

    public Wall(int x, int y, int w, int v) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.v = v;
    }
}
class Fort{
    int x , y , w , v;

    public Fort(int x, int y, int w, int v) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.v = v;
    }
}
class Mine{
    int x , y , w , v;

    public Mine(int x, int y, int w, int v) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.v = v;
    }
}
