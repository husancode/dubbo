package provider;

import api.GreetingService;

public class GreetingsServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}