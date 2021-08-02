package org.coreapi.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class JsonConfig {
    private File file;
    private JSONObject json; // org.json.simple
    private JSONParser parser = new JSONParser();

    private HashMap<String, Object> defaults = new HashMap<String, Object>();

    public JsonConfig(File file) {
        this.file = file;
        reload();
        loadSamples();
        save();
    }

    public void reload() {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                PrintWriter pw = new PrintWriter(file, "UTF-8");
                pw.print("{");
                pw.print("}");
                pw.flush();
                pw.close();
            }
            json = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"));



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadSamples() {
        defaults.put("MyString", "Some String");

        defaults.put("MyNumber", 1337);

        JSONObject myObject = new JSONObject();
        myObject.put("Test", "test");
        myObject.put("Test2", "test2");
        defaults.put("MyObject", myObject);

        JSONArray myArray = new JSONArray();
        myArray.add("Value1");
        myArray.add("Value2");
        defaults.put("MyArray", myArray);
    }

    public String getRawData(String key) {
        return json.containsKey(key) ? json.get(key).toString()
                : (defaults.containsKey(key) ? defaults.get(key).toString() : key);
    }

    public String getString(String key) {
        return ChatColor.translateAlternateColorCodes('&', getRawData(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.valueOf(getRawData(key));
    }

    public double getDouble(String key) {
        try {
            return Double.parseDouble(getRawData(key));
        } catch (Exception ex) { }
        return -1;
    }

    public double getInteger(String key) {
        try {
            return Integer.parseInt(getRawData(key));
        } catch (Exception ex) { }
        return -1;
    }

    public JSONObject getObject(String key) {
        return json.containsKey(key) ? (JSONObject) json.get(key)
                : (defaults.containsKey(key) ? (JSONObject) defaults.get(key) : new JSONObject());
    }

    public JSONArray getArray(String key) {
        return json.containsKey(key) ? (JSONArray) json.get(key)
                : (defaults.containsKey(key) ? (JSONArray) defaults.get(key) : new JSONArray());
    }

    public boolean save() {
        try {
            JSONObject toSave = new JSONObject();

            for (String s : defaults.keySet()) {
                Object o = defaults.get(s);
                if (o instanceof String) {
                    toSave.put(s, getString(s));
                } else if (o instanceof Double) {
                    toSave.put(s, getDouble(s));
                } else if (o instanceof Integer) {
                    toSave.put(s, getInteger(s));
                } else if (o instanceof JSONObject) {
                    toSave.put(s, getObject(s));
                } else if (o instanceof JSONArray) {
                    toSave.put(s, getArray(s));
                }
            }

            // TODO
            TreeMap<String, Object> treeMap = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
            treeMap.putAll(toSave);

            Gson g = new GsonBuilder().setPrettyPrinting().create();
            String prettyJsonString = g.toJson(treeMap);

            FileWriter fw = new FileWriter(file);
            fw.write(prettyJsonString);
            fw.flush();
            fw.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    public static Location jsonToLoc(JSONObject obj, String locname) {
        return new Location(Bukkit.getWorld(obj.get(locname + "world").toString()),
                Double.parseDouble(obj.get(locname + "x").toString()),
                Double.parseDouble(obj.get(locname + "y").toString()),
                Double.parseDouble(obj.get(locname + "z").toString()),
                Float.parseFloat(obj.get(locname + "yaw").toString()),
                Float.parseFloat(obj.get(locname + "pitch").toString()));
    }

    // Location to Json
    @SuppressWarnings("unchecked")
    public static JSONObject locToJson(Location loc, String locname) {
        JSONObject jso = new JSONObject();
        jso.put(locname + "world", loc.getWorld().getName());
        jso.put(locname + "x", loc.getX());
        jso.put(locname + "y", loc.getY());
        jso.put(locname + "z", loc.getZ());
        jso.put(locname + "yaw", loc.getYaw());
        jso.put(locname + "pitch", loc.getPitch());
        return jso;
    }

}
