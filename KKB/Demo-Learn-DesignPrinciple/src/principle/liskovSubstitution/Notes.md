# LSP 里氏替换原则
Liskov Substitution Principle

该原则可以简单理解为：**子类可以替换父类**。

## 复习：使用类继承的优缺点

### 优点

- 代码共享，减少创建类的工作量，每个子类都拥有父类的方法和属性；
- 提高代码的重用性；
- 提高代码的可扩展性，子类可形似于父类，但异于父类，保留了自己独特的个性；
  其实很多开源框架的扩展都是通过继承父类实现的。
- 提供产品或者项目的开放性。

### 缺点

- 继承是侵入性的，只要继承就必须拥有父类的所有方法和属性；
- 降低了代码的灵活性。子类必须拥有父类的属性和方法，让子类中多了约束
- 增加了耦合，当父类的常量、变量或者方法被修改了，需要考虑子类的修改，
  所以一旦父类有了变动，很可能会造成非常糟糕的结果，要重构大量的代码。

---

java中使用extends关键字来实现继承，采用的是单一继承的规则，
C++则采用了多重继承的规则，即一个子类可以继承多个父类。
从整体上上看，使用继承的利是大于弊的，那么怎么才能更大的发挥“利”的作用呢？

Introducing ——— LSP 里氏替换原则

## 里氏替换原则的定义

该原则中有两个定义：
If for each object o1 of type S there is an object o2 of type T such that for all programs P
defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtypeof T.
如果每一个类型S的对象o1，都有一个类型T的对象o2，在以T定义的所有程序P中将所有的对象o2都替换为o1，而程序P的行为没有发生变化，那么S是T的子类

---

Functions that use pointers or references to base classes must be able to use objects of
derived classes without knowing it.
所有引用基类的地方必须能透明地使用其子类对象

---

第一个算是里氏替换原则的前提补充，
其描述的是普遍意义上的基类与子类的定义，其表述为了严谨地导致理解起来有点困难，
从计算机角度简单来说：就是在一个程序中，如果可以将一个类T的对象替换为另一个类S的对象，且程序的行为没有变化，那么S是(普遍意义上的)T的子类。

第二个可以说是真正的对规则本身地定义，
通俗来说：即任意一个使用父类的地方，你都可以把该父类替换为子类，而程序不会出错。
但是反过来就不行了，有子类出现的地方，将其替换为父类未必是可行的

同时在原则上，作为实现了里氏替换原则的结果，
使用者在替换类时，应该不必知道替换的类是被替换的父类还是子类
(这一点比较难翻译，上文中翻译为 透明地)

## 从定义出发的衍生解释 （代码示例）

里氏替换原则是继承复用的基石，它为良好的继承定义了一个规范

（个人理解）可以从定义中提取与衍生出4层含义：

（代码案例为 士兵使用枪械的情景）

### 1. 子类必须完全实现父类的方法

- 抽象类 `枪` 中定义 `射击`方法

    ```java
    package com.wln.principle.lvp;
    
    //枪的抽象类
    public abstract class AbstacTGun {
        //射击
        public abstract void shoot();
    }
    ```

- 继承类 `手枪`、`步枪`、`机枪`等 各自实现自己的`射击`方法

    ```java
    //手枪：携带方便但是射程短
    public class Handgan extends AbstractGun{
    	@Override
    	public void shoot() {
    	System.out.println("手枪射击----------");
    	}
    }
    //步枪：威力大射程远
    public class Rifle extends AbstractGun{
    	@Override
    	public void shoot() {
    	System.out.println("步枪射击----------");
    	}
    }
    //机枪：威力更大连续发射
    public class MachineGun extends AbstractGun{
    	@Override
    	public void shoot() {
    	System.out.println("机枪射击----------");
    	}
    }
    ```

- `士兵`类

    ```java
    package com.wln.principle.lvp;
    //士兵：使用枪支
    public class Solider {
        //士兵使用的枪
        private AbstacTGun gun;
        //通过set方法给士兵配枪
        public void setGun(AbstacTGun gun) {
            this.gun = gun;
        }
        public void killEnemy(){
            System.out.println("士兵杀敌：");
            gun.shoot();
        }
    }
    ```

- `情景`类 — 士兵射击，包含了主方法入口

    ```java
    package com.wln.principle.lvp;
    
    public class Client {
        public static void main(String[] args) {
           //定义一个士兵许三多
    			Soldier xuSanDuo=new Soldier();
    			//给许三多配枪：参数可以是任何一把枪：机枪、步枪都可以
    			xuSanDuo.setGun(new Handgan());
    			xuSanDuo.killEnemy();
        }
    }
    ```


运行结果 略

---

在场景类中，给士兵配枪的时候可以是三种枪中的任何一个，
其实士兵类可以不用知道是哪种的枪（子类）被传入。

PS：在类中调用其他类时，务必要使用父类或接口，
如果不能使用父类或者接口，（而是必须要指定是某一个特定的子类才行）
那么则说明该类的设计违背了里氏替换原则。
（注意上面说的是类中调用，不是具体的对象）

### 2. 子类可以增加自己特有方法

类都有自己的属性和方法，子类当然也不例外。除了从父类继承过来的，可以有自己独有的内容。为什么要单独列出来，是因为里氏替换原则是不可以反过来用的。也就是子类出现的地方，父类未必可以胜任。

- 继续上面的案例：步枪下面还有几个比较知名的种类：例如AK47和AUG狙击步枪。

    ```java
    //AUG狙击枪
    public class AUG extends Rifle{
    	//狙击枪都携带了精准望远镜
    	public void zoomOut(){
    		System.out.println("通过望远镜观察敌人：");
    	}
    	@Override
    	public void shoot() {
    		System.out.println("AUG射击--------");
    	}
    }
    
    //狙击手
    public class Snipper extends Soldier{
    	public void killEnemy(AUG aug) {
    		//先观察
    		aug.zoomOut();
    		//射击
    		aug.shoot();
    	}
    }
    
    //场景类：
    public class Client {
    	public static void main(String[] args){
    		//定义一个狙击手韩光
    		Snipper hanGuang=new Snipper();
    		//给韩光配枪
    		hanGuang.setGun(new AUG());
    		hanGuang.killEnemy();
    	}
    }
    ```


运行结果略

场景类中我们可以直接使用子类，狙击手是依赖枪支的，别说换一个型号的枪，就是同一个型号的枪都会影响射击，所以这里直接传递子类。

- 如果我们直接使用父类传递进来可以吗？

    ```java
    //使用父类作为参数
    public class Client {
    	public static void main(String[] args){
    		//定义一个狙击手韩光
    		Snipper hanGuang=new Snipper();
    		//给韩光配枪
    		hanGuang.setGun((AUG)new Rifle());
    		hanGuang.killEnemy();
    	}
    }
    ```


运行结果略

会在运行的时候抛出异常，
这就是我们经常说的向下转型是不安全的。
从里氏替换原则来看：子类出现的地方，父类未必可以出现。

### 3. 当子类实现或者重写父类的方法时，
方法的输入参数(即形式参数) 要比父类更宽松

宽松：即用子类替换父类时，原先的参数可以直接使用

- 代码示例

  PS：
  这里子类并非重写了父类的方法，而是重载了父类的方法。因为子类和父类的方法的输入参数是不同的。
  子类方法的参数Map比父类方法的参数HashMap的范围要大，所以当参数输入为HashMap类型时，只会执行父类的方法，不会执行父类的重载方法。这符合里氏替换原则。

    ```java
    package com.wln.principle.lvp;
    
    import java.util.HashMap;
    import java.util.Map;
    
    public class LSP {
        //当子类覆盖或者实现父类的方法时，方法的输入参数要比父类的方法输入的参数更宽松
        class Parent{
            public void fun(HashMap map){
                System.out.println("父类被执行....");
            }
        }
        class Sub extends Parent{
            public void fun(Map map){
                System.out.println("子类被执行....");
            }
        }
    
        public static void main(String[] args) {
            System.out.println("父类运行的结果：");
            LSP lsp=new LSP();
            Parent a=lsp.new Parent();
            HashMap<Object,Object> hashMap=new HashMap<>();
            a.fun(hashMap);
            //父类存在的地方可以用子类匪患
            //子类替换父类
            System.out.println("子类替换父类运行的结果：");
            Sub b=lsp.new Sub();
            b.fun(hashMap);
        }
    }
    ```


运行结果略

### 4. 当子类实现父类的抽象方法时，
方法的后置条件(即方法的返回值)要比父类更严格

严格：即用子类替换父类时，其实现的抽象方法返回值应该更具体
即返回的类型是 父类抽象方法返回类型 的子类

- 代码案例

    ```java
    package com.wln.principle.lvp;
    
    import java.util.HashMap;
    import java.util.Map;
    
    public class LSP1 {
        //当子类实现父类的抽象方法时，方法的后置条件要比父类更严格
        abstract class Parent{
            public abstract Map fun();
        }
        class Sub extends Parent{
            @Override
            public HashMap fun(){
                HashMap map=new HashMap();
               map.put("b", "子类被执行");
               return map;
            }
        }
    
        public static void main(String[] args) {
            LSP1 lsp1=new LSP1();
            Parent a=lsp1.new Sub();
            System.out.println( a.fun());
    
        }
    }
    ```


## 里氏替换原则的作用

里氏替换原则的主要作用如下。

1. 里氏替换原则是实现开闭原则的重要方式之一。
2. 它克服了继承中重写父类造成的可复用性变差的缺点。
3. 它是动作正确性的保证。
   即类的扩展不会给已有的系统引入新的错误，降低了代码出错的可能性。

### 通俗的总结

里氏替换原则通俗来讲就是：
（为了整个体系的可复用性）子类可以扩展父类的功能，但不能改变父类原有的功能。

也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。

如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，
但是整个继承体系的可复用性会比较差，
特别是运用多态比较频繁时，程序运行出错的概率会非常大。

如果程序违背了里氏替换原则，则继承类的对象在基类出现的地方会出现运行错误。
这时其修正方法是：取消原来的继承关系，重新设计它们之间的关系。