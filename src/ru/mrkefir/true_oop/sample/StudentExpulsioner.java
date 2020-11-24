package ru.mrkefir.true_oop.sample;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;
import ru.mrkefir.true_oop.Object;

import java.util.List;

public final class StudentExpulsioner extends Object {
    public StudentExpulsioner(String name, MessageMediator messageMediator) {
        super(name, messageMediator);
    }

    @Override
    public Message accept(Message message) {
        String studentName = (String) message.get("name");

        List<String> studentDebts = (List<String>) messageMediator.send(new Message(), studentName)
                                                                  .get("debts");

        if (studentDebts.isEmpty()) {
            return Message.of("decision", "Не отчислен");
        } else  {
            StringBuilder stringBuilder = new StringBuilder();
            studentDebts.forEach(debt -> stringBuilder.append(debt).append(" "));

            return Message.of("decision", "Отчислен из-за долгов: " + stringBuilder.toString());
        }
    }
}
