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
@Data
@Table("loanqualitycategorymatrix")
public class LoanQualityCategoryMatrix implements Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    @PrimaryKeyColumn(name = "kod", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Integer loanServCoeffId;

    @Column("fs1")
    private Integer loanQualityByFsType1;
    @Column("fs2")
    private Integer loanQualityByFsType2;
    @Column("fs3")
    private Integer loanQualityByFsType3;
}
