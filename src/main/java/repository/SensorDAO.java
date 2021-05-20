package repository;

import models.DHTSensor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SensorDAO {

    public List<DHTSensor> getAll() throws IOException {
        Connection connection = null;
        List<DHTSensor> dht = new ArrayList<>();

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://sql-server-21.database.windows.net:1433;" +
                    "database=SQLDataBase;user=Youssef;password=AddMe2021;" +
                    "encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

            try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DhtMeasurements ORDER BY epochTime DESC")) {

                while (resultSet.next()){
                    dht.add(new DHTSensor(resultSet.getString("DeviceId"),resultSet.getFloat("Temperature"),
                            resultSet.getFloat("Humidity"), resultSet.getLong("epochTime")));
                }
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dht;
    }

    public DHTSensor getLatest() throws IOException {
        Connection connection = null;
        DHTSensor dht = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://sql-server-21.database.windows.net:1433;" +
                    "database=SQLDataBase;user=Youssef;password=AddMe2021;" +
                    "encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

            try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT TOP 1 * FROM DhtMeasurements ORDER BY epochTime DESC;")) {

                while (resultSet.next()){
                    dht = (new DHTSensor(resultSet.getString("DeviceId"),resultSet.getFloat("Temperature"),
                            resultSet.getFloat("Humidity"), resultSet.getLong("epochTime")));
                }
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dht;
    }
}
