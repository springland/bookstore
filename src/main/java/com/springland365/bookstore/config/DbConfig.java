package com.springland365.bookstore.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db/db.properties")
@EnableTransactionManagement
public class DbConfig {

    @Value("${db.url}")
    String dbUrl ;

    @Value("${db.username}")
    String userName ;

    @Value("${db.password}")
    String password ;

    @Value("${db.driverClassName}")
    String driverClassName ;

    @Value("${db.dialect}")
    String dialect;

    @Value("{db.hbm2ddl}")
    String hbm2ddl;



    /*
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        PropertySourcesPlaceholderConfigurer  configurer =  new PropertySourcesPlaceholderConfigurer();
        // If we use this we do not need to use @PropertySource("classpath:db/db.properties")
        configurer.setLocation( new ClassPathResource("db/db.properties"));

        return configurer;
    }
*/

    //@Bean
    Properties  hibernateProperties()
    {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", dialect);
        hibernateProp.put("hibernate.hbm2ddl.auto", hbm2ddl);

        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        return hibernateProp;
    }

    @Bean
    public DataSource   dataSource()
    {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(driverClassName);
            hikariConfig.setJdbcUrl(dbUrl);
            hikariConfig.setUsername(userName);
            hikariConfig.setPassword(password);

            hikariConfig.setMaximumPoolSize(5);
            hikariConfig.setConnectionTestQuery("SELECT 1");
            hikariConfig.setPoolName("bookStorePool");
            DataSource dataSource = new HikariDataSource(hikariConfig);



            return dataSource;
        } catch (Exception e) {
            return null;
        }



    }



    //@Bean
    LocalContainerEntityManagerFactoryBean  entityManagerFactory(DataSource dataSource)
    {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPersistenceUnitManager(null);

        JpaVendorAdapter  vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean;


    }
}
