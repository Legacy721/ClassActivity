package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(search("application.db"));



    }

    public static Map<String, String> HashMapFromTextFile(){
        Map<String, String > map = new HashMap<String, String>();
        BufferedReader br = null;

        try{
            File file = new File("/Users/decagon/IdeaProjects/ClassActivity/src/main/resources/application.properties");
            br = new BufferedReader(new FileReader(file));

            String line = null;

            while ((line = br.readLine()) != null){
                String [] words = line.split("=");

                String name = words[0].trim();
                String number = words[1].trim();

                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            if (br != null){
                try{
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return map;
    }

    public static String search(String input){

        Map<String, String> mapFromFile = HashMapFromTextFile();
        String value = null;
        for (Map.Entry<String, String> entry : mapFromFile.entrySet()){
            if (mapFromFile.containsKey(input)) {
                value = mapFromFile.get(input);
            }
            //System.out.println(entry.getKey() + " = " + entry.getValue());
        }


        return value;
    }
}