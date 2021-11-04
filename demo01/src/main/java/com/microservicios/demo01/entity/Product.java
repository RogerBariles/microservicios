package com.microservicios.demo01.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import com.microservicios.demo01.entity.Categoria;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter @Setter @Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descripcion;
    private Integer stock;
    private Double precio;
    private String estado;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;
}
