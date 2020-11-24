package ru.mrkefir.true_oop.sample;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;
import ru.mrkefir.true_oop.Object;

import java.util.List;

public final class Student extends Object {
    private final List<String> debts;


    public Student(String name, MessageMediator messageMediator, List<String> debts) {
        super(name, messageMediator);
        this.debts = debts;
    }


    @Override
    public Message accept(Message message) {
        Message answer = new Message();
        answer.add("debts", debts);

        return answer;
    }
}
