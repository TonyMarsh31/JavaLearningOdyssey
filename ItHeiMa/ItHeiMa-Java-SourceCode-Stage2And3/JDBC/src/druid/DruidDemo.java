package druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池演示
 */
public class DruidDemo {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件

        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("JDBC/src/druid.properties"));
        //4. 获取连接池对象,参数为配置文件中的配置
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. 通过连接池来获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
