package ru.mrkefir.true_oop;

/**
 * Alan Key's Object. It's an abstract class with exactly one abstract method.
 * Override {@link Object#accept(Message)} and define in it custom logic for
 * your particularly object.
 *
 * Unfortunately, you need to pass 2 obligatory params in constructor. This
 * limitation is created to simplify process of registration object in the message mediator
 * and to reduce amount of possible mistakes.
 */
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
