package lambda.streamapi.useStrategePattern.filter.impl;


import lambda.streamapi.User;
import lambda.streamapi.useStrategePattern.filter.MyFilter;

public class AgeFilter implements MyFilter<User> {
    @Override
    public boolean filter(User user) {
        return user.getAge() >= 25;
    }
}
