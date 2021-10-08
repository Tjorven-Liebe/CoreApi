package org.coreapi.database;

import org.coreapi.api.Api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQL implements Database {

    private String host = "";
    private String port = "";
    private String database = "";
    private String username = "";
    private String password = "";
    private static Connection connection;

    public MySQL() {

        if(!isConnected()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port
                        + "/" + database + "?autoReconnect=true", username, password);
                System.out.println("MySQL-Verbindung gestartet!");
            } catch (SQLException e) {
                Api.getLogger().warn("MySQL-Connection failed!");
                Api.getLogger().error(e);
            }
        }
    }

    public void createTable(String name, Map<String, MySQLValueTypes> valuesTypesMap) {

        if (isConnected()) {

            StringBuilder stringBuilder = new StringBuilder("create table if not exists " + name + "(");


            valuesTypesMap.keySet().forEach(key -> {

                String s = "";

                switch (valuesTypesMap.get(key)) {
                    case INTEGER:
                        s = " INT";
                    case VARCHAR:
                        s = " TEXT";
                    default:
                        s = " TEXT";
                }
                stringBuilder.append(key + s);

            });

            stringBuilder.append(")");
            try {
                connection.createStatement().executeUpdate(stringBuilder.toString());
            } catch (SQLException e) {
                Api.getLogger().error(e);
            }
        }
    }

    @Override
    public boolean isConnected() {
        return connection != null;
    }

    @Override
    public DatabaseType getDatabaseType() {
        return DatabaseType.MySQL;
    }

    @Override
    public void updateValue(String database, String key, String value, String where, String is) {

        if(isConnected()) {
            try{

                connection.createStatement().executeUpdate("update " + database + " set " + key + "='" + value + "' where " + where + "='" + is + "'");

            }catch (SQLException e) {
                Api.getLogger().error(e);
            }
        }

    }

    @Override
    public Object getResult(String database, String key, String where, String is) {
        if(isConnected()) {
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("select * from " + database + " where " + where + "='" + is + "'");

                while (resultSet.next()) {

                   return resultSet.getObject("key");

                }

            }catch (SQLException e) {
                Api.getLogger().error(e);
            }
        }return null;
    }

    @Override
    public List<Object> getResultAsList(String database, String key) {

        if(isConnected()) {

            try {
                List<Object> list = new ArrayList<>();

                ResultSet resultSet = connection.createStatement().executeQuery("select * from " + database);

                while (resultSet.next()) {

                    list.add(resultSet.getObject(key));

                }

            }catch (SQLException e) {
                Api.getLogger().error(e);
            }
        }return null;
    }


    @Override
    public List<Object> getResultAsList(String database, String key, String where, String is) {
        if(isConnected()) {
            List<Object> list = new ArrayList<>();
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("select * from " + database + " where " + where + "='" + is + "'");
                while (resultSet.next()) {
                    list.add(resultSet.getObject(key));
                }
            }catch (SQLException e) {
                Api.getLogger().error(e);
            }
            return list;
        }return null;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
