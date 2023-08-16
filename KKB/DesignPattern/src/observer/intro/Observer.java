package observer.intro;

/**
 * 观察者接口
 */
public interface Observer {
    /**
     * 一旦发现明星有行动，就要做出相应的反应
     */
    void update(String context);
}
