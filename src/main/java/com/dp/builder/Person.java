package com.dp.builder;

public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person(){}

    public static class PersonBuilder{
        Person p = new Person();
        public PersonBuilder buildBaseInfo(int id,String name,int age,double weight){
            p.id = id;
            p.name = name;
            p.age = age;
            p.weight = weight;
            return this;
        }
        public PersonBuilder buildScore(int score){
            p.score = score;
            return this;
        }
        public PersonBuilder builderLoc(Location loc){
            p.loc = loc;
            return this;
        }
        public Person build(){
            return p;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}
class Location{
    String street;
    String rootNum;

    public Location(String street, String rootNum) {
        this.street = street;
        this.rootNum = rootNum;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", rootNum='" + rootNum + '\'' +
                '}';
    }
}
