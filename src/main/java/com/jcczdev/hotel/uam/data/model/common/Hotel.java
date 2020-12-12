package com.jcczdev.hotel.uam.data.model.common;

import com.jcczdev.hotel.uam.data.model.location.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String fiscalName;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private HotelGroup group;
    @ManyToMany
    @JoinTable(name = "hotel_currency",
    joinColumns = @JoinColumn(name = "hotel_id"),
    inverseJoinColumns = @JoinColumn(name = "currency_id"))
    private Set<Currency> currencies;

    public Hotel(Long id, String name, String fiscalName, String address, HotelGroup group) {
        this.id = id;
        this.name = name;
        this.fiscalName = fiscalName;
        this.address = address;
        this.group = group;
    }

    public void addCurrency(Currency currency) {
        this.currencies.add(currency);
        currency.getHotels().add(this);
    }

    public void removeCurrency(Currency currency) {
        this.currencies.remove(currency);
        currency.getHotels().remove(this);
    }
}
