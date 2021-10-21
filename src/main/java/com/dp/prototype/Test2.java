package com.dp.prototype;

/**
 * 深克隆，引用的类型也需要深克隆——Loaction
 */
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person2 p1 = new Person2();
        Person2 p2 = (Person2) p1.clone();

        System.out.println(p2.age + ":" + p2.score);
        System.out.println(p2.loc);

        System.out.println("**************");
        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sj";
        System.out.println(p2.loc);
    }
}
class Person2 implements Cloneable{
    int age = 8;
    int score = 100;

    Location2 loc = new Location2("bj","22");
    @Override
    public Object clone() throws CloneNotSupportedException{
        Person2 p = (Person2) super.clone();
        p.loc = (Location2) loc.clone();
        return p;
    }
}
class Location2 implements Cloneable{
    String street;
    String rootNum;

    public Location2(String street, String rootNum) {
        this.street = street;
        this.rootNum = rootNum;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", rootNum='" + rootNum + '\'' +
                '}';
    }
}

