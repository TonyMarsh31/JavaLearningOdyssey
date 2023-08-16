package principle.dependenceInversion;

import principle.dependenceInversion.Cars.ICar;
import principle.dependenceInversion.Drivers.Impl.Driver;
import principle.dependenceInversion.Drivers.IDriver;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

public class Test1 extends TestCase {

    Mockery context=new JUnit4Mockery();

    @Test
    public void test1(){
        ICar car=context.mock(ICar.class);
        IDriver driver=new Driver();
        context.checking(new Expectations(){{
            oneOf(car).run();
        }
        });
        driver.drive(car);
    }
}
