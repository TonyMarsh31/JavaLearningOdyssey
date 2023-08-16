package principle.liskovSubstitution.Example.Soliders;

import principle.liskovSubstitution.Example.Guns.Impl.AUG;

/**
 * 狙击手
 */
public class Snipper extends Solider{

    public void killEnemy(AUG aug) {
        //先观察
        aug.zoomOut();
        aug.shoot();
    }
}
