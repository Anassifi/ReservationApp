package com.anassifi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "public", catalog = "reservationYoucode")
public class ReservationEntity {
    private Long idReservation;
    private Long idUser;
    private String datereservation;
    private Boolean confirmation;
    private Long typeres;
    private TypereservationEntity typereservationByTyperes;

    @Id
    @GeneratedValue
    @Column(name = "id_reservation", nullable = false)
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "id_user", nullable = true)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (!Objects.equals(idReservation, that.idReservation))
            return false;
        if (!Objects.equals(idUser, that.idUser)) return false;
        if (!Objects.equals(datereservation, that.datereservation))
            return false;
        if (!Objects.equals(confirmation, that.confirmation)) return false;
        if (!Objects.equals(typeres, that.typeres)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReservation != null ? idReservation.hashCode() : 0;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (datereservation != null ? datereservation.hashCode() : 0);
        result = 31 * result + (confirmation != null ? confirmation.hashCode() : 0);
        result = 31 * result + (typeres != null ? typeres.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "typeres", referencedColumnName = "id_limit")
    public TypereservationEntity getTypereservationByTyperes() {
        return typereservationByTyperes;
    }

    public void setTypereservationByTyperes(TypereservationEntity typereservationByTyperes) {
        this.typereservationByTyperes = typereservationByTyperes;
    }
}
