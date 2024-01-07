package io.zenwave360.example.delivery.adapters.events.orders;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;

@Mapper
public interface AdapterEventsMapper {

    AdapterEventsMapper INSTANCE = Mappers.getMapper(AdapterEventsMapper.class);

    default Instant asInstant(OffsetDateTime date) {
        return date != null ? date.toInstant() : null;
    }

    default OffsetDateTime asOffsetDateTime(Instant date) {
        return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
    }

}
