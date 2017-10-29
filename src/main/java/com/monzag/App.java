package com.monzag;

import java.util.ArrayList;

public class App {
    private View view = new View();
    private DBcontroller dBcontroller = new DBcontroller();


    public boolean run() throws IndexOutOfBoundsException {
        Options userChoice;
        view.displayMenu();
        int input = view.getUserChoice();
        userChoice = Options.values()[input];

        switch(userChoice) {
            case SUM_OF_PROFITS: showSumOfProfits();
                break;
            case PROFITS_BY_DATA: showProfitsByData();
                break;
            case AMOUNT_OF_RESERVATION_AT_DAY: showAmountOfReservationsAtDay();
                break;
            case AMOUNT_OF_RESERVATION_AT_MONTH: showAmountOfReservationAtMonth();
                break;
            case RESERVATIONS_BY_DATA: showReservationsByData();
                break;
            case RESERVATIONS_BY_PERSON: showReservationsByPerson();
                break;
            case RESERVATIONS_BY_MOVIE: showReservationsByMovie();
                break;
            case RUSH_HOURS: showRushHours();
                break;
            case CHEAPEST_TICKET: showCheapestTicket();
                break;
            case MOST_EXPENSIVE_TICKET: showTheMostExpensiveTicket();
                break;
            case EXIT:
                return false;
        }
        return true;
    }

    public void showSumOfProfits() {
        Double sumOfProfits = dBcontroller.getSumOfProfits();
        System.out.println(sumOfProfits);
    }

    public void showProfitsByData() {
        Double profitsByData = dBcontroller.getProfitsByData();
        System.out.println(profitsByData);
    }

    public void showAmountOfReservationsAtDay() {
        Integer amountAtDay = dBcontroller.getAmountOfReservationsAtDay();
        System.out.println(amountAtDay);
    }

    public void showAmountOfReservationAtMonth() {
        Integer amountAtMonth = dBcontroller.getAmountOfReservationsAtMonth();
        System.out.println(amountAtMonth);
    }

    public void showReservationsByData() {
        ArrayList<Reservation> reservations = dBcontroller.getReservationByData();
        view.displayReservations(reservations);
    }

    public void showReservationsByPerson() {
        ArrayList<Reservation> reservations = dBcontroller.getReservationByPerson();
        view.displayReservations(reservations);
    }

    public void showReservationsByMovie() {
        ArrayList<Reservation> reservations = dBcontroller.getReservationByMovie();
        view.displayReservations(reservations);
    }

    public void showRushHours() {

    }

    public void showCheapestTicket() {
        String cheapestTicket = dBcontroller.getCheapestTicket();
        view.printText(cheapestTicket);

    }

    public void showTheMostExpensiveTicket() {
        String mostExpensiveTicket = dBcontroller.getExpensiveTicket();
        view.printText(mostExpensiveTicket);
    }

    public static void main(String[] args) {
        App app = new App();
        boolean start = true;
        while (start) {
            try {
                start = app.run();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
