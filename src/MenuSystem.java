import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Patrik Melander
 * Date: 2020-10-12
 * Time: 13:57
 * Project: Gym
 * Copyright: MIT
 */
public class MenuSystem {

    public static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean running = true;
        while (running) {
            System.out.println("\n\nVälj vad du vill göra:\n\n" +
                    "1. Hantera medlemmar\n" +
                    "2. PT\n" +
                    "3. Avsluta\n" +
                    "4. Spara alla ändringar");

            input = scan.nextLine();

            switch (input) {
                case "1" -> memberMenu();
                case "2" -> ptMenu();
                case "3" -> running = exitMenu();
                default -> System.out.println("Ange ett giltigt val! (1-3)");
            }
        }
    }

    public static void memberMenu() {
        Gym gym = new Gym();
        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nVälj vad du vill göra:\n" +
                    "1. Sök efter medlem\n" +
                    "2. Kolla om en medlem är aktiv\n" +
                    "3. Förnya medlemskap\n" +
                    "4. Ta bort medlem\n" +
                    "5. Skapa nytt medlemskap\n" +
                    "6. Skriv ut lista på alla medlemmar\n" +
                    "7. Återgå till huvudmenyn");

            input = scan.nextLine();

            switch (input) {
                case "1" -> gym.searchForMember();
                case "2" -> gym.isCustomerActive();
                case "3" -> gym.updateMembership();
                case "4" -> gym.deleteMember();
                case "5" -> gym.createNewMember();
                case "6" -> gym.printListofMembers();
                case "7" -> {
                    return;
                }
                default -> System.out.println("Ange ett giltigt val! (1-7)");
            }
        }
    }

    public static void ptMenu(){
        Gym gym = new Gym();
        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nVälj vad du vill göra:\n" +
                    "1. Skriv ut lista på alla träningstillfällen\n" +
                    "2. Se hur många gånger en person tränat\n" +
                    "3. Återgå till huvudmenyn");

            input = scan.nextLine();

            switch (input) {
                case "1" -> gym.printListOfAllMembersExercise();
                case "2" -> gym.countOneMembersExercise();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Ange ett giltigt val! (1-3)");
            }
        }
    }
    public static boolean exitMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Är du säker på att du vill avsluta? (Ja/Nej) ");
        String input = scan.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("ja")) {
                System.out.println("Tack för besöket! Välkommen åter!");
                return false;
            } else if (input.equalsIgnoreCase("nej")) {
                System.out.println("Stanna så längen du vill");
                return true;
            } else
                System.out.print("Nu blev de fel, testa igen: ");
        }
    }
}