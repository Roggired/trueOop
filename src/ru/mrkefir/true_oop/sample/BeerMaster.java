package ru.mrkefir.true_oop.sample;

import ru.mrkefir.true_oop.Message;
import ru.mrkefir.true_oop.MessageMediator;
import ru.mrkefir.true_oop.Object;

public final class BeerMaster extends Object {
    private int beerGlasses;


    public BeerMaster(String name, MessageMediator messageMediator, int beerGlasses) {
        super(name, messageMediator);
        this.beerGlasses = beerGlasses;
    }


    @Override
    public Message accept(Message message) {
        if (beerGlasses > 0) {
            beerGlasses--;
            return Message.of("beer",true);
        }

        return Message.of("beer", false);
    }
}
