package org.coreapi.util.reader;

import org.coreapi.api.Api;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public JSONObject getJsonObjectFromFile(File file) {

        try {

            return new JSONObject((JSONObject) new JSONParser().parse(new FileReader(file.getPath())));

        } catch (IOException | ParseException e) {
            Api.getLogger().error(e);
        }

        return null;

    }



}
