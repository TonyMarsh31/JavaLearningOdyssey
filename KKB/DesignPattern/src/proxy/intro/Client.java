package proxy.intro;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        //打游戏
        System.out.println("开始时间：" + new Date());
        player.login("张三", "123456");
        player.killBoss();
        player.upgrade();
        System.out.println("结束时间：" + new Date());
    }
}
