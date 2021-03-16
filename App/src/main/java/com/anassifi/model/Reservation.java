package com.anassifi.model;

import javax.persistence.*;

@Entity
@Table(name = "reservation", schema = "public", catalog = "reservationYoucode")
public class Reservation {
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user; //UserEntity userentity

    private String datereservation;
    private Boolean confirmation;
    private Long typeres;
    private Typereservation typereservationByTyperes;

    @Id
    @GeneratedValue
    @Column(name = "id_reservation", nullable = false)
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "datereservation", nullable = true, length = 254)
    public String getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(String datereservation) {
        this.datereservation = datereservation;
    }

    @Basic
    @Column(name = "confirmation", nullable = true)
    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Basic
    @Column(name = "typeres", nullable = true)
    public Long getTyperes() {
        return typeres;
    }

    public void setTyperes(Long typeres) {
        this.typeres = typeres;
    }

    @ManyToOne
    @JoinColumn(name = "typeres", referencedColumnName = "id_limit")
    public Typereservation getTypereservationByTyperes() {
        return typereservationByTyperes;
    }

    public void setTypereservationByTyperes(Typereservation typereservationByTyperes) {
        this.typereservationByTyperes = typereservationByTyperes;
    }
}
