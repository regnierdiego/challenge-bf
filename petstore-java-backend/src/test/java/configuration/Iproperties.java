package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/defaults.properties"
})

public interface Iproperties extends Config {

    @Config.Key("url")
    String url();

    @Config.Key("pathPost")
    String pathPost();

    @Config.Key("pathGet")
    String pathGet();

    @Config.Key("pathPut")
    String pathPut();

}
