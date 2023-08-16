package principle.liskovSubstitution.Example.Guns.Impl;

import principle.liskovSubstitution.Example.Guns.AbstractGun;

/**
 * 步枪：威力大射程远
 */
public class Rifle extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("步枪射击------------");
    }
}
