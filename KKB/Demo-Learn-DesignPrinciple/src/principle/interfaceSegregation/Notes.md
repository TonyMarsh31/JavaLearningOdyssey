# ISP 接口隔离原则
Interface Segregation Principle

接口隔离原则要求程序员尽量将臃肿庞大的接口拆分成更小的和更具体的接口，
让接口中只包含客户感兴趣的方法。

## 定义

2002 年罗伯特·C.马丁给“接口隔离原则”的定义是：

客户端不应该被迫依赖于它不使用的方法
Clients should notbe forced to depend on methods they do not use

该原则还有另外一个定义：
一个类对另一个类的依赖应该建立在最小的接口上
The dependency of one class to another one should depend on the smallest possible
interface

---

以上两个定义的含义是：
要为各个类建立它们需要的专用接口，
而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。

## 补充 — 接口隔离原则和单一职责  与 代码案例

接口隔离原则和单一职责都是为了提高类的内聚性、降低它们之间的耦合性，体现了封装的思想，但两者是不同的：

- 单一职责原则注重的是职责，而接口隔离原则注重的是对接口依赖的隔离。
- 单一职责原则主要是约束类，它针对的是程序中的实现和细节；
  接口隔离原则主要约束接口，主要针对抽象和程序整体框架的构建。

---

---

我们举个栗子说明一下：现在有个特别流行的词:小姐姐。我觉得这是对美女的别称。什么是美女呢？一般来说：首先长得好看，其次身材窈窕，最后还有气质。我们按照这三种要求去寻求美女(也过一把星探的瘾)。

- `美女接口`、`美女类`

    ```java
    //美女接口
    public interface IPettyGirl {
    	//天使面孔
    	void goodLooking();
    	//魔鬼身材
    	void niceFigure();
    	//有气质
    	void greatTemperament();
    }
    
    //美女实现类
    public class PettyGirl implements IPettyGirl{
    	private String name;
    	public PettyGirl(String name) {
    		this.name = name;
    	}
    	@Override
    	public void goodLooking() {
    		System.out.println(this.name+"面容：倾国倾城比天仙");
    	}
    	@Override
    	public void niceFigure() {
    		System.out.println(this.name+"身材：窈窕淑女赛西施");
    	}
    	@Override
    	public void greatTemperament() {
    		System.out.println(this.name+"气质：亭亭玉立似贵妃");
    	}
    }
    ```

- `星探抽象类`、`星探类`

    ```java
    //星探抽象类
    public abstract class AbstractSearcher {
    	protected IPettyGirl girl;
    
    	public AbstractSearcher(IPettyGirl girl) {
    		this.girl = girl;
    	}
    
    	//搜索美女并展示信息
    	public abstract void search();
    }
    
    //星探类
    public class Searcher extends AbstractSearcher{
    	public Searcher(IPettyGirl girl) {
    		super(girl);
    	}
    
    	@Override
    	public void search() {
    		System.out.println("搜索到的美女展示如下：");
    		super.girl.goodLooking();
    		super.girl.niceFigure();
    		super.girl.greatTemperament();
    	}
    }
    ```

- `场景类`

    ```java
    //场景类
    public class Client {
    	public static void main(String[] args) {
    		//定义一个美女
    		IPettyGirl reBa=new PettyGirl("迪丽热巴");
    		AbstractSearcher searcher=new Searcher(reBa);
    		searcher.search();
    	}
    }
    ```


运行结果略

---

我们的审美观点一直在改变，美女的定义也在变化。例如看到一个女孩：身材面容一般，但是气质特别好，我们也会把她成为美女，于是产生了气质美女，但是我们的接口中却定义了美女都必须具备三个条件，按照这个标准，气质美女就不是美女了，怎么办呢？

重新扩展一个美女类，只实现气质方法，其他两个方法置空就好啦！可是星探类AbstractSearcher依赖的是IPettyGirl接口，它有3个方法，星探的方法是不是要修改？

分析到这里，我们发现其实是IPettyGirl的设计有缺陷，过于庞大，容纳了一些可变的因素，根据接口隔离的原则，星探AbstractSearcher应该依赖具有部分特质的女孩子，而我们却把这些都放到了一个接口中。

找到问题原因，接下来就解决问题：

- 我们把臃肿的接口（`美女接口`）分为两个：一个`面容身材好接口`，一个`气质好接口`

    ```java
    public interface IGoodBodyGirl {
    	//天使面孔
    	void goodLooking();
    	//魔鬼身材
    	void niceFigure();
    }
    
    public interface IGreatTemperamentGirl {
    	//有气质
    	void greatTemperament();
    }
    ```

- `美女实现类`:可以根据需求自行选择实现一个或者多个接口

    ```java
    package com.wln.principle.isp;
    
    import java.awt.image.ImageConsumer;
    
    public class PettryGirl implements IGoodsBodyGirl,IGreatTempermentGirl {
        private String name;
    
        public PettryGirl(String name) {
            this.name = name;
        }
    
        @Override
        public void goodLooking() {
            System.out.println(this.name+"面容：倾国倾城比天仙");
        }
    
        @Override
        public void niceFigure() {
            System.out.println(this.name+"身材:窈窕淑女赛西施");
        }
    
        @Override
        public void greatTemperament() {
            System.out.println(this.name+"气质：亭亭玉立似贵妃");
        }
    }
    ```


---

把一个臃肿的接口变为两个（多个）独立的接口所依赖的原则就是接口隔离原则。

## 优点

接口隔离原则是为了约束接口、降低类对接口的依赖性，遵循接口隔离原则有以下 5 个优点。

1. 将臃肿庞大的接口分解为多个粒度小的接口，
   可以预防外来变更的扩散，提高系统的灵活性和可维护性。
2. 接口隔离提高了系统的内聚性，减少了对外交互，降低了系统的耦合性。
3. 如果接口的粒度大小定义合理，能够保证系统的稳定性；
   但是，如果定义过小，则会造成接口数量过多，使设计复杂化；
   如果定义太大，灵活性降低，无法提供定制服务，给整体项目带来无法预料的风险。
4. 使用多个专门的接口还能够体现对象的层次，
   因为可以通过接口的继承，实现对总接口的定义。
5. 能减少项目工程中的代码冗余。
   过大的大接口里面通常放置许多不用的方法，
   当实现这个接口的时候，就需要被迫设计冗余的代码。

## 实现方法

在具体应用接口隔离原则时，应该根据以下几个规则来衡量。

- 接口尽量小，但是要有限度。一个接口只服务于一个子模块或业务逻辑。
- 为依赖接口的类定制服务。只提供调用者需要的方法，屏蔽不需要的方法。
- 了解环境，拒绝盲从。
  每个项目或产品都有选定的环境因素，环境不同，
  接口拆分的标准就不同深入了解业务逻辑。
- 提高内聚，减少对外交互。使接口用最少的方法去完成最多的事情。