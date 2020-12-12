package com.jcczdev.hotel.uam.data.model.common;

import com.jcczdev.hotel.uam.data.model.location.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class HotelGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public HotelGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
