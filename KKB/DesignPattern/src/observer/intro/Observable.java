package observer.intro;

/**
 * 被观察者：明星等人群
 */
public interface Observable {
    /**
     * 添加一个观察者
     *
     * @param observer 谁盯着那些明星在看
     */
    void addObserver(Observer observer);

    /**
     * 删除一个观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 当明星有行动时，通知(被暴露给)观察者
     *
     * @param message 明星的行动
     */
    void notifyObserver(String message);
}
