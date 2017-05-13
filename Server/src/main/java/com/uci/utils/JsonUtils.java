package com.uci.utils;

import com.google.gson.Gson;

public class JsonUtils {
    private JsonUtils() {
    }

    private final static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T toObject(String json, Class<T> clas) {

        return gson.fromJson(json, clas);
    }
}