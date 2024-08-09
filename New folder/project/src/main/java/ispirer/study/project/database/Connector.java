package ispirer.study.project.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class Connector {

    private static Connection connection;
    static Logger logger = Logger.getLogger(Connector.class.getName());

    private static void loadDriver(){
        try{
            Class.forName("com.informix.jdbc.IfxDriver");
            logger.info("Informix Driver load!");
        } catch (ClassNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    public static Connection getConnection(){
        if(connection == null) {
            loadDriver();
            Properties props = loadDatabaseProperties();
            try {
                connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
                logger.info("Get connection to DB!");
            } catch (SQLException e) {
                logger.info(e.getMessage());
            }
        }
            return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            logger.info("Connection to DB close!");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    private static Properties loadDatabaseProperties() {
        InputStream in = Connector.class.getClassLoader().getResourceAsStream("database.properties");
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return props;
    }
}
