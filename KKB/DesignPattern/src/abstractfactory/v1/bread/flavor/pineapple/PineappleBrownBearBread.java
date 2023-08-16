package abstractfactory.v1.bread.flavor.pineapple;

import abstractfactory.v1.bread.color.AbstractBrownBearBread;

public class PineappleBrownBearBread extends AbstractBrownBearBread {
    @Override
    public void getType() {
        System.out.println("布朗熊-----菠萝馅儿----");
    }
}
