package org.example.UserManagement;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserCreationDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;



}
