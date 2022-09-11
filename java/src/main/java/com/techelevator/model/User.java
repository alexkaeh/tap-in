package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "user_id")
   private Long id;

   private String username;

   @JsonIgnore
   @Column(name = "password_hash")
   private String password;

   private String role;

   @JsonIgnore
   private boolean activated;

   private String role;

   @JsonIgnore
   @Transient
   private Set<Authority> authorities = new HashSet<>();

//   Added fields
   @Enumerated(EnumType.STRING)
   @Column(name = "account_type")
   private AccountType accountType;

//   User <-> Brewery relationship requires join table to account for null
//   values when user does not have a brewery
//   @OneToOne(cascade = CascadeType.ALL)
//   @JoinTable(name = "brewer_brewery",
//           joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") },
//           inverseJoinColumns = { @JoinColumn(name = "brewery_id", referencedColumnName = "brewery_id") })
//   private Brewery brewery;

   public User(Long id, String username, String password, String authorities) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.activated = true;
   }


   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
