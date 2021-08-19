package com.udemy.compras.scalar;

import com.udemy.compras.utils.DateUtils;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class DateScalar extends GraphQLScalarType {
    private static final String NAME = "Date";

    public DateScalar() {
        super(NAME, "Date type", new Coercing<LocalDateTime, String>() {

            @Override
            public String serialize(Object o) throws CoercingSerializeException {
                if (o instanceof LocalDateTime) {
                    return DateUtils.fromDate((LocalDateTime) o);
                }
                throw new CoercingSerializeException("Invalid date: " + o);
            }

            @Override
            public LocalDateTime parseValue(Object o) throws CoercingParseValueException {
                if(o instanceof String) {
                    LocalDateTime dateTime = DateUtils.fromString((String) o);
                    if(Objects.nonNull(dateTime)) {
                        return dateTime;
                    }
                }
                throw new CoercingParseValueException("Invalid date: " + o);
            }

            @Override
            public LocalDateTime parseLiteral(Object o) throws CoercingParseLiteralException {
                if(Objects.nonNull(o)) {
                    LocalDateTime dateTime = DateUtils.fromString(o.toString());
                    if(Objects.nonNull(dateTime)) {
                        return dateTime;
                    }
                }
                throw new CoercingParseValueException("Invalid date: " + o);
            }
        });
    }
}
