package factory.v1.factory;

import factory.v1.bread.Bread;

public abstract class AbstractBreadFactory {
    public abstract Bread createBread(Class cls);
}
