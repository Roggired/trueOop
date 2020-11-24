package ru.mrkefir.true_oop;

public abstract class Object {
    protected final String name;
    protected final MessageMediator messageMediator;


    public Object(String name, MessageMediator messageMediator) {
        this.name = name;
        messageMediator.register(this);
        this.messageMediator = messageMediator;
    }


    String getName() {
        return name;
    }

    public abstract Message accept(Message message);
}
