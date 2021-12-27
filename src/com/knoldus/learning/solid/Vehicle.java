package com.knoldus.learning.solid;

public class Vehicle {
    public void startEngine() throws Exception {
    }


    public static void main(String [] a) throws Exception {
        Vehicle v = new Car();
        v.startEngine();
        Vehicle b = new BiCycle();
        b.startEngine();
    }
}

class Car extends Vehicle{
    @Override
    public void startEngine(){
        System.out.println("car start");
    }
}

class BiCycle extends Vehicle{
    @Override
    public void startEngine() throws Exception {
        throw new Exception("Start Engine not supported");
    }
}
