package principle.liskovSubstitution.Example.Guns.Impl;

import principle.liskovSubstitution.Example.Guns.AbstractGun;

/**
 * 手枪：携带方便但是射程短
 */
public class Handgan extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("手枪射击------------");
    }
}
