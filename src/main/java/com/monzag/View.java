package com.monzag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class View {

    public void displayMenu() {
        ArrayList<String> options = new ArrayList<String>(Arrays.asList("Show sum of profits", "Show profits by data",
                "Show amount of reservation by day", "Show amount of reservation by month",
                "Find reservation by data", "Find reservation by person", "Find reservation by movie",
                "Show rush hours", "Display the cheapest ticket", "Display the most expensive ticket"));

        displayOptions(options);
        System.out.println("\n0. Exit");
    }

    public void displayOptions(ArrayList<String> options) {
        Integer number = 1;
        System.out.println(" ");
        for (String option : options) {
            System.out.println(String.format("%d. %s", number, option));
            number++;
        }
    }

    public int getUserChoice() {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.println("Enter a number: ");
        while (!input.hasNextInt()) {
            printErrorMessage();
            input.next();
        }

        number = input.nextInt();
        return number;
    }

    public void printErrorMessage() {
        System.out.println("Error!");
    }

    public void displayReservations(ArrayList<Reservation> reservations) {
        Integer number = 1;
        for (Reservation reservation : reservations) {
            System.out.println(number + ". " + reservation);
            number += 1;
        }
    }

    public void printText(String text) {
        System.out.println(text);
    }
}