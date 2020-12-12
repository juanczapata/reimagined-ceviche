package com.jcczdev.hotel.uam.data.model.useraccount;

import com.jcczdev.hotel.uam.data.model.common.Hotel;
import com.jcczdev.hotel.uam.data.model.common.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserAccount {
    @Id
    private String id;
    private String username;
    private String salt;
    private String hash;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userAccountType_id")
    private UserAccountType userAccountType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    public UserAccount(String id, String username, String salt, String hash, UserAccountType userAccountType, Hotel hotel) {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.hash = hash;
        this.userAccountType = userAccountType;
        this.hotel = hotel;
    }
}
