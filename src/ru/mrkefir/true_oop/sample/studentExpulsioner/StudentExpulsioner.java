package ru.mrkefir.true_oop.sample.studentExpulsioner;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;
import ru.mrkefir.true_oop.Object;

public abstract class StudentExpulsioner extends Object {
    private final String nextExpulsioner;


    public StudentExpulsioner(String name, MessageMediator messageMediator, String nextExpulsioner) {
        super(name, messageMediator);
        this.nextExpulsioner = nextExpulsioner;
    }


    protected Message callNext(Message message) {
        if (nextExpulsioner != null) {
            return messageMediator.send(message, nextExpulsioner);
        }

        return createNotExpelledMessage();
    }

    protected Message createNotExpelledMessage() {
        return Message.of("decision", "Не отчислен");
    }
}
