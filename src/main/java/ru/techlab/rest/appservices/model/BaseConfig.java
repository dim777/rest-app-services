package ru.techlab.rest.appservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.joda.time.LocalDateTime;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.xegex.risks.libs.model.config.Config;

import java.io.Serializable;

/**
 * Created by rb052775 on 05.10.2017.
 */
@Table("config")
@Data
public class BaseConfig implements Config, Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    @PrimaryKeyColumn(name = "id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private Integer id;

    @Column("endofday")
    private String endOfDay;


    @Override
    @JsonIgnore
    public LocalDateTime getJodaEndOfDay() {
        return LocalDateTime.parse(endOfDay);
    }
}
