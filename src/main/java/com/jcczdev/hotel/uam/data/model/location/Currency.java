package com.jcczdev.hotel.uam.data.model.location;

import com.jcczdev.hotel.uam.data.model.common.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String symbol;
    @ManyToMany(mappedBy = "currencies")
    private Set<Hotel> hotels;
}
