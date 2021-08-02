package org.coreapi.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLite implements Database {

    private final String name;
    private static Connection connection;

    public SQLite(String name) {
        this.name = name;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + name + ".db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public boolean isConnected() {
        return connection != null;
    }

    @Override
    public DatabaseType getDatabaseType() {
        return DatabaseType.SQLite;
    }

    @Override
    public void createTable(String name, Map<String, MySQLValueTypes> valuesTypesMap) {
        if (isConnected()) {

            StringBuilder stringBuilder = new StringBuilder("create table if not exists " + name + "(");


            valuesTypesMap.keySet().forEach(key -> {

                String s = "";

                switch (valuesTypesMap.get(key)) {
                    case INTEGER:
                        s = " INT";
                    case VARCHAR:
                        s = " VARCHAR(10000)";
                    default:
                        s = " VARCHAR(10000)";
                }

                stringBuilder.append(key + s);

            });

            stringBuilder.append(")");
            try {
                connection.createStatement().executeUpdate(stringBuilder.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateValue(String database, String key, String value, String where, String is) {

        if(isConnected()) {
            try{

                connection.createStatement().executeUpdate("update " + database + " set " + key + "='" + value + "' where " + where + "='" + is + "'");

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Object getResult(String database, String key, String where, String is) {
        return null;
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
                e.printStackTrace();
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
                e.printStackTrace();
            }
            return list;
        }return null;
    }
}
