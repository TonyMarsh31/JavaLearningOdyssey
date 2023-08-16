package principle.singleRole;

public interface IConnectionManger extends IPhone{
    void dial(String phoneNumber);
    void hangup();
}
