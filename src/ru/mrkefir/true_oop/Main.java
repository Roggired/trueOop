package ru.mrkefir.true_oop;

import ru.mrkefir.true_oop.sample.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public final class Main {
    public static void main(String[] args) {
        boolean robotEnabled    = Boolean.parseBoolean(args[0]);
        boolean ivtEnabled      = Boolean.parseBoolean(args[1]);
        boolean sppoEnabled     = Boolean.parseBoolean(args[2]);
        boolean randomEnabled   = Boolean.parseBoolean(args[3]);
        boolean fullMoonEnabled = Boolean.parseBoolean(args[4]);
        int beerGlasses = new Random().nextInt(4);

        System.out.println("Robot enabled: " + robotEnabled);
        System.out.println("Ivt enabled: " + ivtEnabled);
        System.out.println("Sppo enabled: " + sppoEnabled);
        System.out.println("Random enabled: " + randomEnabled);
        System.out.println("Full moon enabled: " + fullMoonEnabled);
        System.out.println("Beer glasses: " + beerGlasses);

        System.out.println();

        MessageMediator messageMediator = new MessageMediator();

        new BeerMaster("BeerMaster", messageMediator, beerGlasses);
        createStudents(messageMediator);
        createRobotExpulsioner(messageMediator, robotEnabled);
        createIvtExpulsioner(messageMediator, ivtEnabled, randomEnabled);
        createSppoExpulsioner(messageMediator, sppoEnabled, randomEnabled, fullMoonEnabled);

        Message expulsionResult = messageMediator.send(Message.of("name", "Иляна"), "RobotExpulsioner");

        System.out.println("Студент Иляна факультета 'Робототехника'");
        System.out.println(expulsionResult.get("decision"));

        expulsionResult = messageMediator.send(Message.of("name", "Юля"), "IvtExpulsioner");

        System.out.println("Студент Юля факультета 'ИВТ'");
        System.out.println(expulsionResult.get("decision"));

        expulsionResult = messageMediator.send(Message.of("name", "Леша"), "SppoExpulsioner");

        System.out.println("Студент Леша факультета 'СППО'");
        System.out.println(expulsionResult.get("decision"));
    }

    private static void createStudents(MessageMediator messageMediator) {
        new Student("Иляна", messageMediator, Collections.singletonList("программирование"));
        new Student("Леша", messageMediator, Collections.emptyList());
        new Student("Юля", messageMediator, Arrays.asList("программирование", "опд"));
    }

    private static void createIvtExpulsioner(MessageMediator messageMediator, boolean enabled, boolean random) {
        if (!enabled) {
            new DisabledExpulsioner("IvtExpulsioner", messageMediator);
            return;
        }

        String nextExpulsioner = null;
        if (random) {
            new RandomExpulsioner("RandomExpulsioner", messageMediator, null);
            nextExpulsioner = "RandomExpulsioner";
        }

        new DebtsExpulsioner("IvtExpulsioner", messageMediator, nextExpulsioner);
    }

    private static void createSppoExpulsioner(MessageMediator messageMediator, boolean enabled, boolean random, boolean fullMoon) {
        if (!enabled) {
            new DisabledExpulsioner("SppoExpulsioner", messageMediator);
            return;
        }

        String nextExpulsioner = null;
        if (!random && fullMoon) {
            new FullMoonExpulsioner("FullMoonExpulsioner", messageMediator, null);
            nextExpulsioner = "FullMoonExpulsioner";
        }

        new DebtsExpulsioner("SppoExpulsioner", messageMediator, nextExpulsioner);
    }

    private static void createRobotExpulsioner(MessageMediator messageMediator, boolean enabled) {
        if (!enabled) {
            new DisabledExpulsioner("RobotExpulsioner", messageMediator);
            return;
        }

        new DebtsExpulsioner("RobotExpulsioner", messageMediator, null);
    }
}
