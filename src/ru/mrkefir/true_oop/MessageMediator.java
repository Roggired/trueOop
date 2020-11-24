package ru.mrkefir.true_oop;

import java.util.HashMap;
import java.util.Map;

public final class MessageMediator {
    private final Map<String, Object> journal;


    public MessageMediator() {
        journal = new HashMap<>();
    }


    public void register(Object object) {
        journal.put(object.getName(), object);
    }

    public Message send(Message message, String target) {
        return journal.get(target).accept(message);
    }
}