package ftc.shift.sample.models;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Move {
    @ApiModelProperty(value = "Идетификатор перемещения", required = true)
    private String id;
    @ApiModelProperty(value = "Идетификатор вида транспорта", required = true)
    private int transferId;
    @ApiModelProperty(value = "Место начала поездки", required = true)
    private String fromPlace;
    @ApiModelProperty(value = "Дата начала поездки", required = true)
    private Date fromDate;
    @ApiModelProperty(value = "Место конца поездки", required = true)
    private String toPlace;
    @ApiModelProperty(value = "Дата конца поездки", required = true)
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
