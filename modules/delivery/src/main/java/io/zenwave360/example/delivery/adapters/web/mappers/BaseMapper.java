package io.zenwave360.example.delivery.adapters.web.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;
import org.mapstruct.Mapper;

@Mapper
public abstract class BaseMapper {

  public Instant asInstant(OffsetDateTime date) {
    return date != null ? date.toInstant() : null;
  }

  public OffsetDateTime asOffsetDateTime(Instant date) {
    return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
  }
}
