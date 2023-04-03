package my.config.autoconfig;

import lombok.Getter;
import lombok.Setter;
import my.config.MyConfigurationProperties;

@Getter
@Setter
@MyConfigurationProperties(prefix = "data")
public class MyDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
