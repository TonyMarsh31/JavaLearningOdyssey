package proxy.v1;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个代理
        IGamePlayer proxy = new GamePlayerProxy(player);
        //代理帮玩家打游戏
        System.out.println("开始时间：" + new Date());
        proxy.login("张三", "123456");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间：" + new Date());
    }
}
