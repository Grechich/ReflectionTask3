package com.gmail.grechich;

public class Main {
    public static void main(String[] args) throws Exception {
        Simple simple = new Simple("sa", 12, 18);
        String s = Serializator.serialize(simple);
        System.out.println("Serialized: " + s);

        Simple simple1 = Serializator.deserialize(s, Simple.class);
        System.out.println("Deserialized: " + simple1.getStr() + ", " + simple1.getA() + ", " + simple1.getB());
    }

}
