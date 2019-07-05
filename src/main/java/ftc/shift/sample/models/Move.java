package ftc.shift.sample.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Move {
    String id;
    String travelId;
    String fromPlace;
    Date fromDate;
    String toPlace;
    Date toDate;
    double distance;
    int transferId;
    BigDecimal money;

    Collection<MoveNote> moveNotes;

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

    public Collection<MoveNote> getMoveNotes() {
        return moveNotes;
    }

    public Move(String id, String travelId, String fromPlace, Date fromDate, String toPlace, Date toDate, double distance, int transferId, BigDecimal money, Collection<MoveNote> moveNotes) {
        this.id = id;
        this.travelId = travelId;
        this.fromPlace = fromPlace;
        this.fromDate = fromDate;
        this.toPlace = toPlace;
        this.toDate = toDate;
        this.distance = distance;
        this.transferId = transferId;
        this.money = money;
        this.moveNotes = moveNotes;
    }
}
