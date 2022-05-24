package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "purchaselist")
public class Purchaselist {

    @EmbeddedId
    @Getter
    @Setter
    private PurchaseListKey id;

    @Getter
    @Setter
    @Column(name = "price")
    private Integer price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Instant subscriptionDate;


}