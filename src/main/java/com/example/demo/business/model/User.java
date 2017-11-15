package com.example.demo.business.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author wagner on 12/11/17
 */
@Data
@Builder
public class User {

    public String nome;
    public LocalDate birthDate;
}
