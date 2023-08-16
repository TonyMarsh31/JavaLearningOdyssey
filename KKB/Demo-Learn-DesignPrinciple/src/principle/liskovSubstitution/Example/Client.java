package principle.liskovSubstitution.Example;

import principle.liskovSubstitution.Example.Guns.Impl.AUG;
import principle.liskovSubstitution.Example.Guns.Impl.Rifle;
import principle.liskovSubstitution.Example.Soliders.Snipper;
import principle.liskovSubstitution.Example.Soliders.Solider;

public class Client {

    public static void main(String[] args) {
        //定义一个狙击手
        Snipper hanGuang=new Snipper();
        //配枪
        hanGuang.setGun((AUG)new Rifle());
        hanGuang.killEnemy();
    }
    public static void main1(String[] args) {
        //定义一个士兵
        Solider xunSanDuo=new Solider();
        //给许三多配枪
        xunSanDuo.setGun(new Rifle());
        xunSanDuo.killEnemy();
    }
}
