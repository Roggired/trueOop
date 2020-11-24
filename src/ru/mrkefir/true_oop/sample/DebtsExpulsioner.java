package ru.mrkefir.true_oop.sample;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;

import java.util.List;

public final class DebtsExpulsioner extends StudentExpulsioner {
    public DebtsExpulsioner(String name, MessageMediator messageMediator, String nextExpulsioner) {
        super(name, messageMediator, nextExpulsioner);
    }

    @Override
    public Message accept(Message message) {
        String studentName = (String) message.get("name");

        List<String> studentDebts = (List<String>) messageMediator.send(new Message(), studentName)
                                                                  .get("debts");

        if (studentDebts.isEmpty()) {
            return callNext(message);
        }

        StringBuilder stringBuilder = new StringBuilder();
        studentDebts.forEach(debt -> stringBuilder.append(debt).append(", "));

        return Message.of("decision", "Отчислен из-за долгов: " + stringBuilder.toString().substring(0, stringBuilder.length() - 2));
    }
}
