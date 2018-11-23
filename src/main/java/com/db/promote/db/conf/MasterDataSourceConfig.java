package com.db.promote.db.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by smq on 2017/4/22.
 */
@Configuration
@ConfigurationProperties(prefix = "db.master")
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.db.promote.db.master";
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    //初始化大小，最小，最大
    private int initialSize;
    private int minIdle;
    private int maxWait;
    //配置获取连接等待超时的时间
    private int maxActive;
    //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private int timeBetweenEvictionRunsMillis;
    //配置一个连接在池中最小生存的时间，单位是毫秒
    private int minEvictableIdleTimeMillis;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxActive(maxActive);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
         /*超过时间限制是否回收，对于建立时间超过removeAbandonedTimeout的连接强制关闭*/
        dataSource.setRemoveAbandoned(true);
        /*超过时间限制多长,单位秒。默认5分钟*/
        dataSource.setRemoveAbandonedTimeout(5 * 60);
        /*指定发生removeabandoned的时候，是否记录当前线程的堆栈信息到日志中*/
        dataSource.setLogAbandoned(false);
        /*用来检测连接是否有效的sql，要求是一个查询语句*/
        dataSource.setValidationQuery("select 'x'");
        /*申请连接的时候检测*/
        dataSource.setTestWhileIdle(true);
        /*申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能*/
        dataSource.setTestOnBorrow(true);
        /*归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能*/
        dataSource.setTestOnReturn(false);
        /*连接池中的minIdle数量以内的连接，空闲时间超过minEvictableIdleTimeMillis，则会执行keepAlive操作*/
        dataSource.setKeepAlive(true);
        /*是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。*/
        //dataSource.setPoolPreparedStatements(false);
        /*要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true*/
        //dataSource.setMaxPoolPreparedStatementPerConnectionSize(-1);
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource ds)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        //plugins插件，添加updateTime修改时间字段
        return sessionFactory.getObject();
    }




    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
}
