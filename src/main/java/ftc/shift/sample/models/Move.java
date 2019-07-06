package ftc.shift.sample.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Move {
    private String id;
    private String travelId;
    private String fromPlace;
    private Date fromDate;
    private String toPlace;
    private Date toDate;
    private double distance;
    private int transferId;
    private BigDecimal money;

    public void setId(String id) {
        this.id = id;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getTravelId() {
        return travelId;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public String getToPlace() {
        return toPlace;
    }

    public Date getToDate() {
        return toDate;
    }

    public double getDistance() {
        return distance;
    }

    public int getTransferId() {
        return transferId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Move(){ }

    public Move(String id, String travelId, String fromPlace, Date fromDate, String toPlace, Date toDate, double distance, int transferId, BigDecimal money) {
        this.id = id;
        this.travelId = travelId;
        this.fromPlace = fromPlace;
        this.fromDate = fromDate;
        this.toPlace = toPlace;
        this.toDate = toDate;
        this.distance = distance;
        this.transferId = transferId;
        this.money = money;
    }
}
