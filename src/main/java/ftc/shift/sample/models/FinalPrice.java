package ftc.shift.sample.models;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class FinalPrice {
    @ApiModelProperty(value = "Идетификатор путешествия", required = true)
    String id;
    @ApiModelProperty(value = "Итоговая стоимость поездки", required = true)
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
