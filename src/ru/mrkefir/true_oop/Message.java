package ru.mrkefir.true_oop;

import java.util.HashMap;
import java.util.Map;

public final class Message {
    private final Map<String, java.lang.Object> data;


    public Message() {
        data = new HashMap<>();
    }


    public java.lang.Object get(String key) {
        return data.get(key);
    }

    public Message add(String key, java.lang.Object object) {
        data.put(key, object);
        return this;
    }
}
