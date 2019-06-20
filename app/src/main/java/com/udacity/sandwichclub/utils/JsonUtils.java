package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        ArrayList<String> alsk = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObject1 = jsonObject.getJSONObject("name");
            String main_name = jsonObject1.getString("mainName");
            JSONArray als = jsonObject1.getJSONArray("alsoKnownAs");
            for (int i = 0; i < als.length(); i++) {
                alsk.add(als.getString(i));
            }
            String plo = jsonObject.getString("placeOfOrigin");
            String des = jsonObject.getString("description");
            JSONArray ingred = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredient = new ArrayList<>();
            for (int i = 0; i < ingred.length(); i++) {
                ingredient.add(ingred.getString(i));
            }
            String iurl = jsonObject.getString("image");
            return new Sandwich(main_name, alsk, plo, des, iurl, ingredient);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return null;
    }
}
