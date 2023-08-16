package abstractfactory.v1.bread.flavor.mango;

import abstractfactory.v1.bread.color.AbstractBrownBearBread;

public class MangoBrownBearBread extends AbstractBrownBearBread {

    @Override
    public void getType() {
        System.out.println("布朗熊-----芒果馅儿----");
    }
}
