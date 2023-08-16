package abstractfactory.v1.factory;

import abstractfactory.v1.bread.Bread;
import abstractfactory.v1.bread.flavor.mango.MangoBlackBearBread;
import abstractfactory.v1.bread.flavor.mango.MangoBrownBearBread;
import abstractfactory.v1.bread.flavor.mango.MangoPolarBearBread;

public class MangoFactory implements BreadFactory {
    @Override
    public Bread createPolarBearBread() {
        return new MangoPolarBearBread();
    }

    @Override
    public Bread createBlackBearBread() {
        return new MangoBlackBearBread();
    }

    @Override
    public Bread createBrownBearBread() {
        return new MangoBrownBearBread();
    }
}
