package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/main.properties")
public interface BaseConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://reqres.in/api")
    String baseUrl();

}