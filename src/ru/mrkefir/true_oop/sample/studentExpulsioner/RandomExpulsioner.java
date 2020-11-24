package ru.mrkefir.true_oop.sample.studentExpulsioner;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;

import java.util.Random;

public final class RandomExpulsioner extends StudentExpulsioner {
    private static final Random RANDOM = new Random();


    public RandomExpulsioner(String name, MessageMediator messageMediator, String nextExpulsioner) {
        super(name, messageMediator, nextExpulsioner);
    }


    @Override
    public Message accept(Message message) {
        if (RANDOM.nextInt(2) == 0) {
            return Message.of("decision", "Отчислен по воле монетки");
        }

        return callNext(message);
    }
}
