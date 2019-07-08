package ftc.shift.sample.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Move {
    private String id;
    private int transferId;
    private String fromPlace;
    private Date fromDate;
    private String toPlace;
    private Date toDate;
    private double distance;
    private BigDecimal money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Move(){ }

    public Move(String id, int transferId, String fromPlace, Date fromDate, String toPlace, Date toDate, double distance, BigDecimal money) {
        this.id = id;
        this.transferId = transferId;
        this.fromPlace = fromPlace;
        this.fromDate = fromDate;
        this.toPlace = toPlace;
        this.toDate = toDate;
        this.distance = distance;
        this.money = money;
    }
}
