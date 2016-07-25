package com.peaceful.demo.spring.boot.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
@Configuration // 该注解声明该类为一个配置类，他也会被spring container 作为一个bean管理
@MapperScan("com.peaceful.demo.spring.boot.dao")
public class AppDataSourceConfig {


    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Lazy
    public DataSource dataSource() {
        DataSource dataSource = new ComboPooledDataSource();
//        new Monitor((ComboPooledDataSource) dataSource).start();
        return dataSource;

    }

    @Bean
    @Lazy
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }

    private class Monitor extends Thread {

        private final Logger LOGGER = LoggerFactory.getLogger(Monitor.class);

        private ComboPooledDataSource dataSource;

        public Monitor(ComboPooledDataSource dataSource) {
            this.dataSource = dataSource;
            LOGGER.info("open datasource monitor for {}", dataSource.getJdbcUrl());
        }

        @Override
        public void run() {
            for (; ; ) {
                String jdbcUrl = dataSource.getJdbcUrl();
                int acquireIncrement = dataSource.getAcquireIncrement();
                int numConn = 0;
                int busyNumConn = 0;
                try {
                    numConn = dataSource.getNumConnections();
                    busyNumConn = dataSource.getNumBusyConnections();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(jdbcUrl + ": AcquireIncrement->" + acquireIncrement + " NumConnections->" + numConn+" NumBusyConnections->"+busyNumConn);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
