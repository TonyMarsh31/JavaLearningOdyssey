package builder.intro.v2.builder;

import builder.intro.v2.car.Benz;
import builder.intro.v2.car.CarModel;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder {

    private Benz benz = new Benz();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benz;
    }
}
