# DIP 依赖倒置原则
Dependence Inversion Principle

依赖倒置原则是实现开闭原则的重要途径之一，它降低了客户与实现模块之间的耦合。

由于在软件设计中，细节具有多变性，而抽象层则相对稳定，
因此以抽象为基础搭建起来的架构要比以细节为基础搭建起来的架构要稳定得多。
这里的抽象指的是接口或者抽象类，而细节是指具体的实现类。

使用接口或者抽象类的目的是制定好规范和契约，而不去涉及任何具体的操作，
把展现细节的任务交给它们的实现类去完成。

## 定义

依赖倒置原则的原始定义为:
High level modules shouldnot depend upon low level modules.
Both should depend upon abstractions.
Abstractions should not depend upon details.
Details should depend upon abstractions。

个人翻译为以下两层含义：

- 高层模组不应该依赖底层模组，两者应该都依赖于其抽象（抽象指的是 抽象类、接口）
- 抽象不应该依赖于细节，而细节应该依赖抽象  （细节指的是 具体的实现类）

再浓缩一下核心思想就是：**要面向抽象(接口)编程，不要面向实现编程**

## 作用

- 降低类间的耦合性。
- 提高系统的稳定性。
- 减少并行开发引起的风险。
- 提高代码的可读性和可维护性。

## 代码案例 — 司机开汽车

### 我们从反面出发，试试不遵循依赖倒置原则会出现怎样的问题

- `奔驰车`、`司机`、`场景`类 司机的驾驶方法需要传入奔驰车参数

    ```java
    //奔驰车
    public class Benz {
    	public void run(){
    		System.out.println("奔驰汽车飞驰-------------");
    	}
    }
    
    public class Driver {
    	//司机驾驶汽车
    	public void drive(Benz benz){
    		System.out.print("司机开车：");
    		benz.run();
    	}
    }
    
    //场景类
    public class Client {
    	public static void main(String[] args) {
    		Driver james=new Driver();
    		Benz benz=new Benz();
    		james.drive(benz);
    	}
    }
    ```


运行结果略

司机开奔驰车这个项目没有问题了。业务需求变更的时候更能发觉我们的设计或程序是否是松耦合。所以现在我们填个需求：司机不仅能开奔驰车，还能开宝马车，该怎么实现呢？

- 不管怎么实现，先把`宝马`车(类)产出出来：

    ```java
    //宝马车
    public class BMW {
    	public void run(){
    		System.out.println("宝马车飞驰-----------");
    	}
    }
    ```


车有了，可是我们的司机james竟然没办法开动，james没有开动宝马的方法啊！拿了驾照只能开奔驰也不太合理吧！现实世界都不这样，更何况程序还是对现实世界的抽象呢。

很显然，我们的设计不合理：司机类和奔驰车类之间是紧耦合的关系，结果就是系统的可维护性降低、可阅读性降低，两个相似的类要阅读两个类；这里增加了一个车类就需要修改司机类，让程序变得不稳定。这样我们就证明了不使用依赖导致原则就没有前两个好处。

---

继续证明“减少并行开发的风险”，什么是并行开发风险？本来只是一段程序的错误或者异常，逐步波及一个功能、一个模块，甚至最后毁掉整个项目。为什么并行开发有这也的风险？假如一个团队有20个人，各人负责不同的功能模块，A负责汽车类，B负责司机类......在A未完成的情况下，B不能完全地编写代码，因为缺少汽车类编译器编译根本通不过，就更不用说单元测试了！在这种不使用依赖倒置原则的情况下，所有的开发都是“单线程”的，只能是A做完B再做......在早期的小型项目中还可以，但在现在的中大型项目中就不合适了，需要团队人员同时并行开发，所以这个时候依赖原则的作用就体现出来了。因为根据上面的案例已经说明不使用依赖倒置原则就会增加类直接的耦合性，降低系统的稳定性、可读性和维护性，增加了并行开发的风险。

### 修改案例代码，使其遵循依赖倒置原则

- `汽车接口`、`奔驰车`类，`宝马车`类

    ```java
    //汽车接口
    public interface ICar {
    	void run();
    }
    //奔驰车
    public class Benz implements ICar{
    	@Override
    	public void run(){
    		System.out.println("奔驰汽车飞驰-------------");
    	}
    }
    //宝马车
    public class BMW implements ICar{
    	@Override
    	public void run(){
    		System.out.println("宝马车飞驰-----------");
    	}
    }
    ```

- `司机接口`、`司机`类

    ```java
    //司机接口
    public interface IDriver {
    	//司机驾驶汽车:通过传入ICar接口实现了抽象之间的依赖关系
    	void drive(ICar car);
    }
    //司机类实现司机接口
    public class Driver implements IDriver {
    	//司机驾驶汽车：实现类也传入ICar接口，至于到底是哪个型号的车，需要在高层模块中声明
    	@Override
    	public void drive(ICar car){
    		System.out.print("司机开车：");
    		car.run();
    	}
    }
    ```

- `场景`类

    ```java
    //场景类：属于高层业务逻辑，他对底层的依赖都建立在抽象上
    public class Client {
    	public static void main(String[] args) {
    		IDriver james=new Driver();
    		ICar benz=new Benz();
    		james.drive(benz);
    	}
    }
    ```


james和benz表明的类型都是接口，是抽象的，虽然在实例化对象的时候调用了低层模块，但是后续所有操作中，james都是以IDriver类型进行操作，屏蔽了细节对抽象的影响。

如果我们此时再新增一个低层模块，只修改业务场景类，也就是高层模块，对其它低层模块不需要做任何修改，业务依然可以运行，把变更引起的风险扩散降到最低。

依赖倒置对并行开发的影响。只要定义好了接口，即使负责Car开发的程序员工作滞后，我们依然可用进行测试。

- 具体可以引入了JMock工具，根据抽象虚拟一个对象进行测试
  （不了解该测试工具也没关系，以后有机会再了解）。

    ```java
    import org.jmock.Expectations;
    import org.jmock.Mockery;
    import org.jmock.integration.junit4.JUnit4Mockery;
    import junit.framework.TestCase;
    import org.junit.Test;
    public class DriverTest extends TestCase {
    	Mockery context=new JUnit4Mockery();
    
    	@Test
    	public void test1(){
    		final ICar car=context.mock(ICar.class);
    		IDriver driver=new Driver();
    		context.checking(new Expectations(){{
    				oneOf(car).run();
    			}
    		});
    		driver.drive(car);
    	}
    }
    ```


## 实现方法（需要遵循的约束）

依赖倒置原则的目的是通过要面向接口的编程来降低类间的耦合性，
所以我们在实际编程中只要遵循以下几点，就能在项目中满足这个规则

1. 每个类尽量提供接口或抽象类，或者两者都具备。
2. 变量的声明类型尽量是接口或者是抽象类。
3. 任何类都不应该从具体类派生。
4. 尽量不要覆写基类的方法
5. 使用继承时结合里氏替换原则。