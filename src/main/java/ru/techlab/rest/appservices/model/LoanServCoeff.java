package ru.techlab.rest.appservices.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/**
 * Created by rb052775 on 05.10.2017.
 */
@Table("loanservcoeff")
@Data
public class LoanServCoeff implements Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    @PrimaryKeyColumn(name = "type", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private String type;

    @PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Integer id;

    @Column("isle")
    private Boolean isLegalEntitity;

    @Column("forlastndays")
    private Integer forLastNDays;

    @Column("moreoreqthandays")
    private Integer moreOrEqThanDays;

    @Column("lessthandays")
    private Integer lessThanDays;
}
