package abstractfactory.v1.bread.flavor.mango;


import abstractfactory.v1.bread.color.AbstractPolarBearBread;

public class MangoPolarBearBread extends AbstractPolarBearBread {

    @Override
    public void getType() {
        System.out.println("北极熊-----芒果馅儿----");
    }
}
