import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String regExNumbofList = "\\d+";
    public static String regExADD = "[A-a][D-d]{1,2}";
    public static String regExEDIT = "[E-e][D-d][I-i][T-t]";
    public static String regExLIST = "[L-l][I-i][S-s][T-t]";
    public static String regExDELETE = "[D-d][E-e][L-l][E-e][T-t][E-e]";
    public static String command;
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static String addMessage;
    public static Integer numbOfList;
    public static Integer i;

    public static void main(String[] args) {

        while (true) {

            commandImplement();
        }
    }

    public static void commandImplement() {

        command = new Scanner(System.in).nextLine();
        command = command.replaceAll("\\p{Space}", "");
        command = command.replaceAll("\\p{Punct}", "");

        if (command.matches(regExADD)) {
            System.out.println("Enter ADD message:");
            addMessage = new Scanner(System.in).nextLine();
            arrayList.add(addMessage);
            System.out.println("List to do: ");
            for (numbOfList = 0; numbOfList < arrayList.size(); numbOfList++) {
                System.out.println(numbOfList + ": " + arrayList.get(numbOfList));
            }


        } else if (command.matches(regExEDIT)) {
            System.out.println("Enter EDIT message:");
            addMessage = new Scanner(System.in).nextLine();
            System.out.println("Enter number of list to EDIT: ");
            numbOfList = Integer.parseInt(new Scanner(System.in).next());
            if (String.valueOf(numbOfList).matches(regExNumbofList)) {
                if (numbOfList < arrayList.size()) {
                    if (arrayList.indexOf(numbOfList) == arrayList.indexOf(numbOfList)) {
                        arrayList.set(numbOfList, addMessage);
                        for (i = 0; i < arrayList.size(); i++) {
                            System.out.println(i + ": " + arrayList.get(i));
                        }
                    } else System.out.println("Wrong numb of list!");
                } else System.out.println("Wrong number of list!");
            } else System.out.println("Wrong number of list!");


        } else if (command.matches(regExLIST)) {
            System.out.println("List to do: ");
            for (i = 0; i < arrayList.size(); i++) {
                System.out.println(i + ": " + arrayList.get(i));
            }


        } else if (command.matches(regExDELETE)) {
            System.out.println("Enter number of list to \u001B[31m DELETE \u001B[0m :");
            numbOfList = Integer.parseInt(new Scanner(System.in).nextLine());
            if (String.valueOf(numbOfList).matches(regExNumbofList)) {
                if (numbOfList <= arrayList.size()) {
                    if (arrayList.indexOf(numbOfList) == arrayList.indexOf(numbOfList) && arrayList.size() != 0) {
                        arrayList.remove(arrayList.get(numbOfList));
                        System.out.println("The list number of " + "\u001B[31m" + numbOfList + "\u001B[0m" + " has been " + "\u001B[31mDELETED\u001B[0m!");
                        for (i = 0; i < arrayList.size(); i++) {
                            System.out.println(i + ": " + arrayList.get(i));
                        }
                    } else if (arrayList.size() == 0) {
                        arrayList.add(0, "");
                        arrayList.remove(arrayList.get(numbOfList));
                        System.out.println("The list number of " + "\u001B[31m" + numbOfList + "\u001B[0m" + " has been " + "\u001B[31mDELETED\u001B[0m!");
                    }
                } else System.out.println("Wrong number of list!");
            }
        } else System.out.println("\u001B[31mWrong command\u001B[0m");
    }
}

