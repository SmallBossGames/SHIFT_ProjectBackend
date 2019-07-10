package ftc.shift.sample.models;

import java.math.BigDecimal;

public class FinalPrice {
    String id;
    BigDecimal price;

    public FinalPrice(){}

    public FinalPrice(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
