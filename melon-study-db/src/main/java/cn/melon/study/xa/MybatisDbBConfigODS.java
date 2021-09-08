package cn.melon.study.xa;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.XADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * MybatisDbBConfigODS
 *
 * @author imelonkid
 * @date 2021/09/03 16:56
 **/
@Configuration
public class MybatisDbBConfigODS extends DataSourceConfig{

    @Autowired
    XADataSourceWrapper wrapper;

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.ods")
    public DataSourceProperties getDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource getDataSource() throws Exception {
        XADataSource xaDataSource = createXaDataSource(getDataSourceProperties());
        return this.wrapper.wrapDataSource(xaDataSource);
    }

}
