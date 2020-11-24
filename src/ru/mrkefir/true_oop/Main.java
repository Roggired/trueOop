package ru.mrkefir.true_oop;

import ru.mrkefir.true_oop.sample.Student;
import ru.mrkefir.true_oop.sample.StudentExpulsioner;

import java.util.Collections;

public final class Main {
    public static void main(String[] args) {
        MessageMediator messageMediator = new MessageMediator();

        new Student("Иляна", messageMediator, Collections.singletonList("программирование"));
        new Student("Леша", messageMediator, Collections.emptyList());

        new StudentExpulsioner("отчислятор", messageMediator);

        Message expulsionResult = messageMediator.send(new Message()
                                                            .add("name", "Иляна"),
                                                "отчислятор");

        System.out.println("Студент Иляна факультета 'Робототехника'");
        System.out.println(expulsionResult.get("decision"));

        expulsionResult = messageMediator.send(new Message()
                                                    .add("name", "Леша"),
                                        "отчислятор");

        System.out.println("Студент Леша факультета 'Программная инженерия'");
        System.out.println(expulsionResult.get("decision"));
    }
}
