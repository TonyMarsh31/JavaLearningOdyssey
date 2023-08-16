package principle.interfaceSegregation.Searcher;

import principle.interfaceSegregation.Girl.IPettyGirl;

public abstract class AbstractSearcher {

    protected IPettyGirl girl;

    public AbstractSearcher(IPettyGirl girl) {
        this.girl = girl;
    }

    public abstract void search();
}
