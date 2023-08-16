# OCP 开闭原则
Open Closed Principle

## 开闭原则定义

开闭原则由勃兰特·梅耶（Bertrand Meyer）提出，
他在 1988 年的著作《面向对象软件构造》（Object OrientedSoftware Construction）
中提出：

软件实体应当**对扩展开放，对修改关闭**
（Software entities should be open for extension，but closed for modification），

这就是开闭原则的经典定义。简单点说就是是：

一个软件实体应该通过扩展来实现变化，
而不是通过修改已有的代码来实现变化。

## 那么什么是软件实体呢？

这里的软件实体包括以下几个部分：

- 项目中划分出的模块
- 类与接口
- 方法

一个软件产品在她的生命周期内一般都会发生变化，
开闭原则视为软件实体的未来事件而制定的对现行开发设计进行约束的一个原则。

## 以一个简短的 书店销售书籍 程序为例

- 代码
    - 书籍接口

        ```java
        package com.wln.principle.ocp;
        //书籍接口
        public interface IBook {
            String getName();
            int getPrice();
            String getAuthor();
        }
        ```

    - 小说类

        ```java
        package com.wln.principle.ocp;
        
        //小说类
        public class NovelBook implements IBook {
            private String name;
            private int price;
            private String author;
        		// 构造方法和 getset省略
        }
        ```

    - 书店类 - 含有main方法入口

        ```java
        package com.wln.principle.ocp;
        
        import java.util.ArrayList;
        
        public class BookStroe {
            private static ArrayList<IBook> bookList=new ArrayList<>();
        
            static {
                bookList.add(new OffNovelBook("红楼梦", 9900, "曹雪芹"));
                bookList.add(new OffNovelBook("侠客行", 8900, "金庸"));
                bookList.add(new OffNovelBook("原则", 6900, "瑞达利欧"));
                bookList.add(new OffNovelBook("海贼王1", 4900, "尾田荣一郎"));
            }
        
            public static void main(String[] args) {
                System.out.println("卖书的记录如下----------------------");
                for (IBook book : bookList) {
                    System.out.println("书籍名称："+book.getName()+"\t\t作者："+book.getAuthor()+"\t\t价格：￥"+book.getPrice()/100.0+"元");
                }
            }
        }
        ```

- 运行结果图示

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f8d956a9-7ca8-442d-9340-d71c1d48e0e6/Untitled.png)


对这样一个小规模的程序来说，书籍现在可以正常销售。
但假设书店决定要来一波促销活动：
70元以上的书籍9折销售，
70元以下的书籍8折销售。

对该项目来说，这就是一个变化，我们该怎么应该如下变化呢？有3中解决方法：

### （1）修改接口

在IBook接口里新增getOffPrice()方法，其专门用于进行打折，

但这样修改的后果就是其所有实现类都需要重写：
实现类NovelBook要修改，书店类BookStore中的main方法也要修改，

同时，IBook作为接口应该是稳定且可靠的，不应该经常发生变化，

因此，该方案被否定。

### （2）修改实现类

修改NovelBook类中的方法，直接在getPrice()方法中实现打折处理，

这个方法可以是可以，但如果采购书籍的人员要看价格怎么办，
由于该方法已经进行了打折处理，因此采购人员看到的也是打折后的价格，
会因信息不对称出现决策失误的情况。

因此，该方案也不是一个最优的方案。

### （3）通过拓展实现变化

增加一个子类OffNovelBook，覆写getPrice方法，

高层次的模块（也就是BookStore中static静态块中）
通过OffNovelBook类产生新的对象，完成业务变化对系统的最小开发。

这样修改也少，风险也小。

- OffNovelBook代码  （NovelBook接口的另一实现类）

    ```java
    package com.wln.principle.ocp;
    //扩展的子类
    public class OffNovelBook extends NovelBook{
    
        public OffNovelBook(String name, int price, String author) {
            super(name, price, author);
        }
    
        @Override
        public int getPrice() {
            int sellPrice=super.getPrice();
            int offPrice=0;
            if(sellPrice>7000){
                offPrice=sellPrice*90/100;
            }else{
                offPrice=sellPrice*80/100;
            }
            return offPrice;
        }
    }
    ```

- 运行结果图示

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4f5fe9d5-059a-41a9-8983-43192b52c544/Untitled.png)


## 小结 开闭原则作用

开闭原则是面向对象程序设计的终极目标，
它使软件实体拥有一定的适应性和灵活性的同时具备稳定性和延续性。

具体来说，其作用如下

### 1. 对软件测试的影响

软件遵守开闭原则的话，软件测试时只需要对扩展的代码进行测试就可以了，
因为原有的测试代码仍然能够正常运行。

### 2. 可以提高代码的可复用性

粒度越小，被复用的可能性就越大；
在面向对象的程序设计中，根据原子和抽象编程可以提高代码的可复用性。

### 3. 可以提高软件的可维护性

遵守开闭原则的软件，其稳定性高和延续性强，从而易于扩展和维护。