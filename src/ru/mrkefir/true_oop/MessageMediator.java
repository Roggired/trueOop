package ru.mrkefir.true_oop;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public final class MessageMediator {
    private final Map<String, Object> journal;


    public MessageMediator() {
        journal = new HashMap<>();
    }


    public void register(Object object) {
        journal.put(object.getName(), object);
    }

    public void unregister(String name) {
        journal.remove(name);
    }

    public Message send(Message message, String target) {
        if (!journal.containsKey(target)) {
            throw new NoSuchElementException("Cannot find an object with given name: " + target);
        }

        return journal.get(target).accept(message);
    }
}