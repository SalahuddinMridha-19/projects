
package travelagency.Pojo;


public class Flight {
    private int id;
    private String flightName;
    private String flightClass;
    private double flightCharge;
    private String seats;
    private String destination;
    private String departureTime;
    private String arivalTime;
    private String ticketNo;

    public Flight() {
    }

    public Flight(int id) {
        this.id = id;
    }

    public Flight(String flightName, String flightClass, double flightCharge, String seats, String destination, String departureTime, String arivalTime, String ticketNo) {
        this.flightName = flightName;
        this.flightClass = flightClass;
        this.flightCharge = flightCharge;
        this.seats = seats;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arivalTime = arivalTime;
        this.ticketNo = ticketNo;
    }

    public Flight(int id, String flightName, String flightClass, double flightCharge, String seats, String destination, String departureTime, String arivalTime, String ticketNo) {
        this.id = id;
        this.flightName = flightName;
        this.flightClass = flightClass;
        this.flightCharge = flightCharge;
        this.seats = seats;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arivalTime = arivalTime;
        this.ticketNo = ticketNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public double getFlightCharge() {
        return flightCharge;
    }

    public void setFlightCharge(double flightCharge) {
        this.flightCharge = flightCharge;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArivalTime() {
        return arivalTime;
    }

    public void setArivalTime(String arivalTime) {
        this.arivalTime = arivalTime;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }
    
}
