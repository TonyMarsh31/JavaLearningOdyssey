package builder.intro.v1.builder;

import builder.intro.v1.car.CarModel;

import java.util.ArrayList;

public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);

    public abstract CarModel getCarModel();

}
