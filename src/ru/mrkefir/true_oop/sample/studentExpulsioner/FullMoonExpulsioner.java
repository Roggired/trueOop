package ru.mrkefir.true_oop.sample.studentExpulsioner;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;

public final class FullMoonExpulsioner extends StudentExpulsioner {
    public FullMoonExpulsioner(String name, MessageMediator messageMediator, String nextExpulsioner) {
        super(name, messageMediator, nextExpulsioner);
    }

    @Override
    public Message accept(Message message) {
        return Message.of("decision", "Отчислен, потому что полнолуние");
    }
}
