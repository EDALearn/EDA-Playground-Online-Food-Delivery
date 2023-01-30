package io.zenwave360.example.restaurants.core.implementation.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper {

    default OffsetDateTime asOffsetDateTime(Instant value) {
        return value == null ? null : OffsetDateTime.ofInstant(value, OffsetDateTime.now().getOffset());
    }

}
