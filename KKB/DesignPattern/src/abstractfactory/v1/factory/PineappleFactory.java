package abstractfactory.v1.factory;


import abstractfactory.v1.bread.Bread;
import abstractfactory.v1.bread.flavor.pineapple.PineappleBlackBearBread;
import abstractfactory.v1.bread.flavor.pineapple.PineappleBrownBearBread;
import abstractfactory.v1.bread.flavor.pineapple.PineapplePolarBearBread;

public class PineappleFactory implements BreadFactory {
    @Override
    public Bread createPolarBearBread() {
        return new PineapplePolarBearBread();
    }

    @Override
    public Bread createBlackBearBread() {
        return new PineappleBlackBearBread();
    }

    @Override
    public Bread createBrownBearBread() {
        return new PineappleBrownBearBread();
    }
}
