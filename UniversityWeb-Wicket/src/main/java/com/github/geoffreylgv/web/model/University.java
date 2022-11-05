package com.github.geoffreylgv.model;

import com.github.geoffreylgv.web.model.Country;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author geoffreylgv
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class University implements Serializable {

    private Long id;
    private String name;
    private String director;
    private String language;
    private LocalDate foundedDate;
    private Country country;
    private Address address;
    private TypeUniv type;

}
