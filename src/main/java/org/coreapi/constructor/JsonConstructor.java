package org.coreapi.constructor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonConstructor {

        JSONObject jsonObject;
        private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        public JsonConstructor() {

                jsonObject = new JSONObject();


        }

        public JsonConstructor addObject(String key, Object value) {

                jsonObject.put(key, value);

               return this;
        }

        public JSONObject getJsonObject() {

                return jsonObject;

        }

        public File createJsonFile(String name, String folderPath) {

                File file = new File(folderPath + name + ".json");

                try{
                        file.createNewFile();
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write(GSON.toJson(jsonObject));
                        fileWriter.close();
                }catch (IOException e) {

                        e.printStackTrace();

                }

        }




}
