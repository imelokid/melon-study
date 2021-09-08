package cn.melon.study.xa;

import javax.sql.XADataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * DataSourceConfig
 *
 * @author imelonkid
 * @date 2021/09/03 16:51
 **/
public class DataSourceConfig {

    ClassLoader beanClassLoader;

    protected XADataSource createXaDataSource(DataSourceProperties properties) {
        String className = properties.getXa().getDataSourceClassName();
        if (!StringUtils.hasLength(className)) {
            className = DatabaseDriver.fromJdbcUrl(properties.determineUrl())
                .getXaDataSourceClassName();
        }
        Assert.state(StringUtils.hasLength(className),
            "No XA DataSource class name specified");
        XADataSource dataSource = createXaDataSourceInstance(className);
        bindXaProperties(dataSource, properties);
        return dataSource;
    }

    private XADataSource createXaDataSourceInstance(String className) {
        try {
            Class<?> dataSourceClass = ClassUtils.forName(className, this.beanClassLoader);
            Object instance = BeanUtils.instantiateClass(dataSourceClass);
            Assert.isInstanceOf(XADataSource.class, instance);
            return (XADataSource) instance;
        }
        catch (Exception ex) {
            throw new IllegalStateException(
                "Unable to create XADataSource instance from '" + className + "'");
        }
    }

    private void bindXaProperties(XADataSource target,
        DataSourceProperties dataSourceProperties) {
        Binder binder = new Binder(getBinderSource(dataSourceProperties));
        binder.bind(ConfigurationPropertyName.EMPTY, Bindable.ofInstance(target));
    }

    private ConfigurationPropertySource getBinderSource(
        DataSourceProperties dataSourceProperties) {
        MapConfigurationPropertySource source = new MapConfigurationPropertySource();
        source.put("user", dataSourceProperties.determineUsername());
        source.put("password", dataSourceProperties.determinePassword());
        source.put("url", dataSourceProperties.determineUrl());
        source.putAll(dataSourceProperties.getXa().getProperties());
        ConfigurationPropertyNameAliases aliases = new ConfigurationPropertyNameAliases();
        aliases.addAliases("user", "username");
        return source.withAliases(aliases);
    }
}
