package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    @Column(name = "year_of_issue")
    private Short year;
    private int fuelcapacity;
    private int seats;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "airplane_id")
    private Set<AirplaneValuation> values;

}
