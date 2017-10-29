package com.monzag;

import java.sql.*;
import java.util.ArrayList;

public class DBcontroller {

    public Double getSumOfProfits() {
        Double sumOfProfits = 0d;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT SUM(price) FROM cinema_reservation;";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                sumOfProfits = result.getDouble(1);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sumOfProfits;
    }

    public Double getProfitsByData() {
        Double sumOfProfitsByData = 0d;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT SUM(price) FROM cinema_reservation WHERE data='21.09.2017';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                sumOfProfitsByData = result.getDouble(1);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sumOfProfitsByData;
    }


    public Integer getAmountOfReservationsAtDay() {
        Integer amountAtDay = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT COUNT(data) FROM cinema_reservation WHERE data='21.09.2017';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                amountAtDay = result.getInt(1);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return amountAtDay;
    }

    public Integer getAmountOfReservationsAtMonth() {
        Integer amountAtMonth = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT COUNT(data) FROM cinema_reservation WHERE data LIKE '%.09.%';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                amountAtMonth = result.getInt(1);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return amountAtMonth;
    }


    public ArrayList<Reservation> getReservationByData() {
        ArrayList<Reservation> reservations = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT * FROM cinema_reservation WHERE data='20.09.2017';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Reservation reservation = createReservation(result);
                reservations.add(reservation);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }

    public ArrayList<Reservation> getReservationByMovie() {
        ArrayList<Reservation> reservations = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT * FROM cinema_reservation WHERE movie LIKE '%King%';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Reservation reservation = createReservation(result);
                reservations.add(reservation);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }

    public ArrayList<Reservation> getReservationByPerson() {
        ArrayList<Reservation> reservations = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT * FROM cinema_reservation WHERE name='Kristyn' AND surname='Tibbotts';";
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                Reservation reservation = createReservation(result);
                reservations.add(reservation);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reservations;
    }



    public Reservation createReservation(ResultSet result) throws SQLException {
        String movie = result.getString(4);
        Double price = result.getDouble(5);
        Integer place = result.getInt(8);
        String data = result.getString(6);
        String hour = result.getString(7);
        String name = result.getString(2);
        String surname =  result.getString(3);
        String holder = name + " " + surname;
        Reservation reservation = new Reservation(movie, price, place, data, hour, holder);

        return reservation;
    }

    public String getCheapestTicket() {
        StringBuilder sb = new StringBuilder("Ticket: ");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT movie, data, MIN(price) FROM cinema_reservation;";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                String movie = result.getString(1);
                String data = result.getString(2);
                Double price = result.getDouble(3);

                sb.append(price).append(" | ");
                sb.append(movie).append(" | ");
                sb.append(data);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sb.toString();
    }

    public String getExpensiveTicket() {
        StringBuilder sb = new StringBuilder("Ticket: ");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./target/database.db");
             Statement stmt = connection.createStatement();) {

            String sqlQuery = "SELECT movie, data, MAX(price) FROM cinema_reservation;";
            ResultSet result = stmt.executeQuery(sqlQuery);

            if (result.next()) {
                String movie = result.getString(1);
                String data = result.getString(2);
                Double price = result.getDouble(3);

                sb.append(price).append(" | ");
                sb.append(movie).append(" | ");
                sb.append(data);
            }
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sb.toString();
    }


}
