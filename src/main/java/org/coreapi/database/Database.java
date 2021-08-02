package org.coreapi.database;

import java.util.List;
import java.util.Map;

public interface Database {

    boolean isConnected();

    DatabaseType getDatabaseType();

    void createTable(String name, Map<String, MySQLValueTypes> valuesTypesMap);

    void updateValue(String database, String key, String value, String where, String is);

    Object getResult(String database, String key, String where, String is);

    List<Object> getResultAsList(String database, String key);

    List<Object> getResultAsList(String database, String key, String where, String is);

}
