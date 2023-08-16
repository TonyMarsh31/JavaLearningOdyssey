package principle.dependenceInversion.Cars.Impl;

import principle.dependenceInversion.Cars.ICar;

/**
 * 奔驰车
 */
public class Benz implements ICar {
    @Override
    public void  run(){
        System.out.println("奔驰车飞驰-----------------");
    }
}
