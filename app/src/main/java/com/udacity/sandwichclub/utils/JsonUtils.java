package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        // Create a JSON Obj from our String and extract data from it
        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonName = jsonObject.getJSONObject("name");
        String mainName = jsonName.getString("mainName");

        // [START - Convert JSONArray for "alsoKnownAs" to List<String>]
        JSONArray alsoKnownAsArray = jsonName.getJSONArray("alsoKnownAs");
        ArrayList<String> alsoKnownAsArrayList = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++){
            alsoKnownAsArrayList.add(alsoKnownAsArray.getString(i));
        }
        List<String> alsoKnownAsList = alsoKnownAsArrayList.subList(0, alsoKnownAsArrayList.size());
        // [END - Convert "alsoKnownAs" JSONArray to List<String>]

        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");

        // [START - Convert "ingredients" JSONArray to List<String>]
        JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
        ArrayList<String> ingredientsArrayList = new ArrayList<>();
        for (int j = 0; j < ingredientsArray.length(); j++){
            ingredientsArrayList.add(ingredientsArray.getString(j));
        }
        List<String> ingredientsList = ingredientsArrayList.subList(0, ingredientsArrayList.size());
        // [END - Convert JSONArray for "ingredients" to List<String>]

        return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image,
                ingredientsList);
    }
}
