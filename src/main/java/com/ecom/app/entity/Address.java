package com.ecom.app.entity;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="pincode")
    private String pincode;
    @Column(name="type_of_address")
    private String typeOfAddress;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
