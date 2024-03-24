package DataDriven;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    public String getJsonValue(String filePath , String jsonPath) {
        JSONParser jsonParser = new JSONParser();

        // Read JSON file and parse
        Object obj = null;
        try {
            obj = jsonParser.parse(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Cast Object to JSONObject
        JSONObject jsonObject = (JSONObject) obj;
        return   (String) jsonObject.get(jsonPath);


    }
}