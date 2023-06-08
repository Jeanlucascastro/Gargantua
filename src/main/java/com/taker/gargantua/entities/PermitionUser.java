package com.taker.gargantua.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "permition")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermitionUser implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;


    @Override
    public String getAuthority() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermitionUser permition = (PermitionUser) o;
        return Objects.equals(id, permition.id) && Objects.equals(description, permition.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
