package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String JSON_NAME_KEY = "name";
    private static final String JSON_MAIN_NAME_KEY = "mainName";
    private static final String JSON_ALSO_KNOWN_AS_KEY = "alsoKnownAs";
    private static final String JSON_ORIGIN_KEY = "placeOfOrigin";
    private static final String JSON_DESCRIPTION_KEY = "description";
    private static final String JSON_IMAGE_URL_KEY = "image";
    private static final String JSON_INGREDIENTS_KEY = "ingredients";


    public static Sandwich parseSandwichJson(String json) throws JSONException {
        // Create a JSON Obj from our String and extract data from it
        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonName = jsonObject.getJSONObject(JSON_NAME_KEY);
        String mainName = jsonName.optString(JSON_MAIN_NAME_KEY);

        // [START - Convert JSONArray for "alsoKnownAs" to List<String>]
        JSONArray alsoKnownAsArray = jsonName.optJSONArray(JSON_ALSO_KNOWN_AS_KEY);
        List<String> alsoKnownAsArrayList = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++){
            alsoKnownAsArrayList.add(alsoKnownAsArray.getString(i));
        }
        // [END - Convert "alsoKnownAs" JSONArray to List<String>]

        String placeOfOrigin = jsonObject.optString(JSON_ORIGIN_KEY);
        String description = jsonObject.optString(JSON_DESCRIPTION_KEY);
        String image = jsonObject.optString(JSON_IMAGE_URL_KEY);

        // [START - Convert "ingredients" JSONArray to List<String>]
        JSONArray ingredientsArray = jsonObject.optJSONArray(JSON_INGREDIENTS_KEY);
        List<String> ingredientsArrayList = new ArrayList<>();
        for (int j = 0; j < ingredientsArray.length(); j++){
            ingredientsArrayList.add(ingredientsArray.getString(j));
        }
        // [END - Convert JSONArray for "ingredients" to List<String>]

        return new Sandwich(mainName, alsoKnownAsArrayList, placeOfOrigin, description, image,
                ingredientsArrayList);
    }
}
