package com.anassifi.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "public", catalog = "reservationYoucode")
public class Student extends User {
    private Long idUser;
    private Long reservationmax;
    private User user;

    @OneToMany(mappedBy ="user")
    private List<Reservation> reservations;
    //maped by reservation

    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "reservationmax", nullable = true)
    public Long getReservationmax() {
        return reservationmax;
    }

    public void setReservationmax(Long reservationmax) {
        this.reservationmax = reservationmax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        if (!Objects.equals(idUser, that.idUser)) return false;
        if (!Objects.equals(reservationmax, that.reservationmax))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (reservationmax != null ? reservationmax.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public User getUserByIdUser() {
        return user;
    }

    public void setUserByIdUser(User user) {
        this.user = user;
    }

}
