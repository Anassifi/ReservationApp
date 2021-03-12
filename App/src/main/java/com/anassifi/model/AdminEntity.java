package com.anassifi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin", schema = "public", catalog = "reservationYoucode")
public class AdminEntity {
    private Long idUser;
    private UserEntity userByIdUser;

    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (!Objects.equals(idUser, that.idUser)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUser != null ? idUser.hashCode() : 0;
    }

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
