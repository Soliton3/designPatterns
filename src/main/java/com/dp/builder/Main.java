package com.dp.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder t = new ComplexTerrainBuilder();
        Terrain te = t.builderWall().builderFort().builderMine().build();

        Person p = new Person.PersonBuilder()
                .buildBaseInfo(1,"小王",20,130)
                .buildScore(90)
                .builderLoc(new Location("珞喻路","1037号"))
                .build();
        System.out.println(p.toString());
    }
}
