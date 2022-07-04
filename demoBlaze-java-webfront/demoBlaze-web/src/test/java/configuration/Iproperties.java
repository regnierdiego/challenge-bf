package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/default.properties"
})
public interface Iproperties extends Config {
    @Config.Key("url")
    String url();
}
