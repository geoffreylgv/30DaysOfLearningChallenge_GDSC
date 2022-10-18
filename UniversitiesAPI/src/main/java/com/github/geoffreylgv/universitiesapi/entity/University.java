package com.github.geoffreylgv.universitiesapi.entity;

import com.github.geoffreylgv.universitiesapi.utils.enumation.TypeUniv;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *
 * @author geoffreylgv
 */
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "UNIVERSITIES")
public class University implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "FOUNDED")
    private LocalDate foundedDate;

    @JoinColumn(name = "COUNTRY_ID")
    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.PERSIST)
    private Country country;

    @JoinColumn(name = "ADDRESS_ID")
    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_UNIV")
    private TypeUniv type;

}
