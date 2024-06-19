package idusw.springboot.lswblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Value("jdbc:mysql://localhost:3306/db_202012070")
    private String url;

    @Value("root")
    private String username;

    @Value("cometrue")
    private String password;

    @Value("${db.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }
}
