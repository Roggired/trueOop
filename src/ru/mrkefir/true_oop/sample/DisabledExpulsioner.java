package ru.mrkefir.true_oop.sample;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;

public final class DisabledExpulsioner extends StudentExpulsioner {
    public DisabledExpulsioner(String name, MessageMediator messageMediator) {
        super(name, messageMediator, null);
    }

    @Override
    public Message accept(Message message) {
        Message answer = messageMediator.send(new Message(), "BeerMaster");
        boolean beerIsGiven = (Boolean) answer.get("beer");

        if (beerIsGiven) {
            return Message.of("decision", "Студент не проверяется отчислятором и получает стакан пива!");
        }

        return Message.of("decision", "Студент не проверяется отчислятором, но пиво кончилось :(");
    }
}
