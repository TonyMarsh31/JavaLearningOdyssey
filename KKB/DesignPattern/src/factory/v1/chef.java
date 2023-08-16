package factory.v1;

import factory.v1.bread.Bread;
import factory.v1.bread.impl.BlackBearBread;
import factory.v1.bread.impl.BrownBearBread;
import factory.v1.bread.impl.PolarBearBread;
import factory.v1.factory.AbstractBreadFactory;
import factory.v1.factory.Impl.BreadFactory;

public class chef {
    public static void main(String[] args) {
        //来一个helloKitty烤箱
        AbstractBreadFactory helloKitty = new BreadFactory();
        //大厨第1次烤面包稍显急躁，时间不足，于是产生了北极熊面包
        System.out.println("----大厨第1次烤面包");
        Bread polarBearBread = helloKitty.createBread(PolarBearBread.class);
        polarBearBread.getColor();
        //大厨第2次烤面包耐心十足，时间过长，于是产生了黑熊面包
        System.out.println("----大厨第2次烤面包");
        Bread blackBearBread = helloKitty.createBread(BlackBearBread.class);
        blackBearBread.getColor();
        //大厨第3次烤面包机智无比,时间刚刚好，于是产生了布朗熊面包
        System.out.println("----大厨第3次烤面包");
        Bread brownBearBread = helloKitty.createBread(BrownBearBread.class);
        brownBearBread.getColor();
    }
}
