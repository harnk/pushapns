package nd.tesserae.phoneagent.pushapns.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by dscottnull on 7/24/18.
 */

@Configuration
public class DBConfig {

    @Value("${source_db_path}")
    private String sourceDatabasePath;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:"+sourceDatabasePath+"/studentlife.db");
        return dataSourceBuilder.build();
    }
}
