package br.com.wallet.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {

    private String name;
    private String password;
    private String email;
}
