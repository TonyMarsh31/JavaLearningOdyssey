package abstractfactory.v1.bread.flavor.pineapple;

import abstractfactory.v1.bread.color.AbstractBlackBearBread;

public class PineappleBlackBearBread extends AbstractBlackBearBread {

    @Override
    public void getType() {
        System.out.println("黑熊-----菠萝馅儿----");
    }
}
