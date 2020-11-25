package ru.mrkefir.true_oop;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit of information. You can use named constructor {@link Message#of(String, java.lang.Object)}
 * to create a message with one claim.
 *
 * Remember that you need to explicitly cast java.lang.Object to type you want.
 */
public final class Message {
    private final Map<String, java.lang.Object> data;


    public Message() {
        data = new HashMap<>();
    }


    public static Message of(String key, java.lang.Object object) {
        return new Message().add(key, object);
    }


    public java.lang.Object get(String key) {
        return data.get(key);
    }

    public Message add(String key, java.lang.Object object) {
        data.put(key, object);
        return this;
    }
}
