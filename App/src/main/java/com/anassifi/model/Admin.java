package com.anassifi.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_user")
@Table(name = "admin", schema = "public", catalog = "reservationYoucode")
public class Admin extends User {

    private User user;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public User getUserByIdUser() {
        return user;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.user = userByIdUser;
    }
}
