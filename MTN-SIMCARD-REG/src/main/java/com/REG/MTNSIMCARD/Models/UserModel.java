package com.REG.MTNSIMCARD.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User_Tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
