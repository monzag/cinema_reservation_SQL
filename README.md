Run maven project:

mvn clean package
mvn flyway:migrate
java -cp target/cinemaReservation-1.0-SNAPSHOT.jar com.monzag.App 
