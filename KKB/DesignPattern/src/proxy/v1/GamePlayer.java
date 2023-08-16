package proxy.v1;

public class GamePlayer implements IGamePlayer {
    private String nickname = "";

    public GamePlayer(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("登录名为" + username + "的用户" + nickname + "登录成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(nickname + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(nickname + "升级了！");
    }
}
