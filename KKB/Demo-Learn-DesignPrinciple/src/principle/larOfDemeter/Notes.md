# LOD 迪米特法则
Law of Demeter

## 定义

迪米特法则（Law of Demeter，LoD）
又叫作最少知识原则（Least Knowledge Principle，LKP)，
产生于 1987 年美国东北大学（Northeastern University）的一个名为迪米特（Demeter）的研究项目，由伊恩·荷兰（IanHolland）提出，

它要求一个对象应该对其他对象有最少的了解。通俗的说，一个类应该对自己需要耦合或调用的类知道的最少，被耦合或调用的类的内部是如何复杂都与我无关，我就知道你提供的public方法就好。

迪米特法则还是在讲如何减少耦合的问题，类之间的耦合越弱，越有利于复用，一个处在弱耦合的类被修改，不会对有关系的类造成波及。也就是说，信息的隐藏促进了软件的复用。

---

迪米特法则还有一个定义是：只与你的直接朋友交谈，不跟“陌生人”说话
（Talk only to your immediate friendsand not to strangers）。
其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。

什么叫做直接的朋友呢？每个对象都必然会和其他对象有耦合关系，两个对象之间的耦合就 成为朋友关系，这种关系有很多比如组合、聚合、依赖等等。包括以下几类：

1. 当前对象本身（this）
2. 当前对象的方法参数（以参数形式传入到当前对象方法中的对象）
3. 当前对象的成员对象
4. 如果当前对象的成员对象是一个集合，那么集合中的元素也都是朋友
5. 当前对象所创建的对象

## 优点

- 降低了类之间的耦合度，提高了模块的相对独立性。
- 由于亲合度降低，从而提高了类的可复用率和系统的扩展性。

但是，过度使用迪米特法则会使系统产生大量的中介类，从而增加系统的复杂性，使模块之间的通信效率降低。所以，在釆用迪米特法则时需要反复权衡，确保高内聚和低耦合的同时，保证系统的结构清晰。

## 实现方法

从迪米特法则的定义和特点可知，它强调以下两点：

1. 从依赖者的角度来说，只依赖应该依赖的对象。
2. 从被依赖者的角度说，只暴露应该暴露的方法。

---

所以，在运用迪米特法则时要注意以下 6 点。

1. 在类的划分上，应该创建弱耦合的类。
   类与类之间的耦合越弱，就越有利于实现可复用的目标。
2. 在类的结构设计上，尽量降低类成员的访问权限。
3. 在类的设计上，优先考虑将一个类设置成不变类。
4. 在对其他类的引用上，将引用其他对象的次数降到最低。
5. 不暴露类的属性成员，而应该提供相应的访问器（set 和 get 方法）。
6. 谨慎使用序列化（Serializable）功能。

## 代码案例

举个栗子：明星平时档期都很满，例如拍电影、演出、粉丝见面会等等，那么他们的这些日程是怎么来的呢？一般都是由经纪人负责处理。这里的经纪人是明星的朋友，而见面会上的粉丝和拍电影或举办演出的媒体公司是陌生人，所以适合使用迪米特法则.

- 代码

    ```java
    package com.wln.principle.dop;
    
    public class Client {
        public static void main(String[] args) {
            Agent agent=new Agent();
            agent.setStar(new Star("迪丽热巴"));
            agent.setFans(new Fans("小九"));
            agent.meeting();
            agent.setCompany(new Company("荔枝电视台"));
            agent.business();
        }
    }
    
    class Agent{
        private Star star;
        private Fans fans;
        private Company company;
    
        public void meeting(){
            System.out.println(this.fans.getName()+"与明星"+this.star.getName()+"见面啦");
        }
    
        public void business(){
            System.out.println(this.company.getName()+"与明星"+this.star.getName()+"商谈合作");
        }
    
        public void setStar(Star star) {
            this.star = star;
        }
    
        public void setFans(Fans fans) {
            this.fans = fans;
        }
    
        public void setCompany(Company company) {
            this.company = company;
        }
    }
    
    class Star{
        private  String name;
    
        public Star(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    }
    
    class Fans{
        private  String name;
    
        public Fans(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    }
    
    class Company{
        private  String name;
    
        public Company(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    }
    ```


运行结果略