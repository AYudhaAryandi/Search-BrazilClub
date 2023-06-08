package object;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public model ResultData(String q) {
        String namaFile = "C:\\Users\\LENOVO\\IdeaProjects\\demo\\BrazilClub\\src\\object\\brazil-club.json";
        model resModel = new model();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(namaFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            String jsonString = stringBuilder.toString();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            JsonNode jsonArray = jsonNode.get("clubs");

            for(int i = 0; i < jsonArray.size(); i++) {
                String resName = jsonArray.get(i).get("name").toString();
                String newString = "\"" + q + "\"";
                if(newString.equals((resName))){
                    resModel.setName(jsonArray.get(i).get("name").toString());
                    resModel.setCode(jsonArray.get(i).get("code").toString());
                    resModel.setCountry(jsonArray.get(i).get("country").toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resModel;

    }
}