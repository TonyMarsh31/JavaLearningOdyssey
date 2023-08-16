package builder.intro.v2.builder;

import builder.intro.v2.car.CarModel;

import java.util.ArrayList;

public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);

    public abstract CarModel getCarModel();

}
