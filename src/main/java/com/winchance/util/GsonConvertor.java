package com.winchance.util;

import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class GsonConvertor {
    private static final ThreadLocal<Gson> gsonLocal = new ThreadLocal<Gson>() {
        @Override
        protected Gson initialValue() {
            return new Gson();
        }
    };

    public static String toJson(Object object) {
        return gsonLocal.get().toJson(object);
    }

    public static String toJson(Object object, Type type) {
        return gsonLocal.get().toJson(object, type);
    }

    public static <T> T fromJson(String jsonString, Class<T> classOfT)
            throws JsonSyntaxException {
        return gsonLocal.get().<T>fromJson(jsonString, classOfT);
    }

    public static <T> T fromJson(String jsonString, Type type)
            throws JsonSyntaxException {
        return gsonLocal.get().<T>fromJson(jsonString, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> classOfT)
            throws JsonIOException, JsonSyntaxException  {
        return gsonLocal.get().<T>fromJson(reader, classOfT);
    }

    public static <T> T fromJson(Reader reader, Type type)
            throws JsonIOException, JsonSyntaxException  {
        return gsonLocal.get().<T>fromJson(reader, type);
    }
}
