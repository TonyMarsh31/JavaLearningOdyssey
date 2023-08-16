package decorator.universal;

/**
 * 具体构件
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体构件的操作");
    }

}
