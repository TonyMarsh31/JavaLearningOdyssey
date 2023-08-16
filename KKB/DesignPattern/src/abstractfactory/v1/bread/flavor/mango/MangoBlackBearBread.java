package abstractfactory.v1.bread.flavor.mango;

import abstractfactory.v1.bread.color.AbstractBlackBearBread;

public class MangoBlackBearBread extends AbstractBlackBearBread {

    @Override
    public void getType() {
        System.out.println("黑熊-----芒果馅儿----");
    }
}
