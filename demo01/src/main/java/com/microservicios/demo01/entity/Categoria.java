package com.microservicios.demo01.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @Data// SETEAMOS GET Y SET POR LOMBOK
@AllArgsConstructor // contructor (todas las propiedades)
@NoArgsConstructor // contructor vacio
@Builder // poder instanciar
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
