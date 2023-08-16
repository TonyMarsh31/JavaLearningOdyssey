package principle.liskovSubstitution.Example.Soliders;

import principle.liskovSubstitution.Example.Guns.AbstractGun;

/**
 * 士兵：使用枪支射击
 */
public class Solider {
    //士兵使用的枪
    private AbstractGun gun;
    //通过set方法给士兵配枪
    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }
    public void killEnemy(){
        System.out.println("士兵杀敌：");
        gun.shoot();
    }
}
