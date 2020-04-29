package com.springland365.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    protected DataSource dataSource;
    public DatabaseInitializer(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    @Override
    public void run(String... args) throws Exception {
        DatabasePopulatorUtils.execute( databasePopulator(), dataSource);
    }

    @Value("classpath:db/book.sql")
    Resource bookScript;
    DatabasePopulator databasePopulator()
    {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator() ;
        populator.addScript(bookScript);
        return populator;
    }

}
