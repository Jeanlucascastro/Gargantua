package com.taker.gargantua.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    @Getter
    @Setter
    private String userName;

    @Column(name = "full_name")
    @Getter
    @Setter
    private String fullName;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "account_non_expired")
    @Getter
    @Setter
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    @Getter
    @Setter
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    @Getter
    @Setter
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    @Getter
    @Setter
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")},
            inverseJoinColumns = {@JoinColumn (name = "id_permission")}
    )
    @Getter
    @Setter
    private List<PermitionUser> permissions;


    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (PermitionUser permission : permissions) {
            roles.add(permission.getDescription());
        }
        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(userName, users.userName) && Objects.equals(fullName, users.fullName) && Objects.equals(password, users.password) && Objects.equals(accountNonExpired, users.accountNonExpired) && Objects.equals(accountNonLocked, users.accountNonLocked) && Objects.equals(credentialsNonExpired, users.credentialsNonExpired) && Objects.equals(enabled, users.enabled) && Objects.equals(permissions, users.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, fullName, password, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, permissions);
    }
}
