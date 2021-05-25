package com.hunza.test.document.child;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Location {
    @NotNull(message = "City is mandatory")
    @NotEmpty(message = "City is mandatory")
    @Pattern(regexp="^[A-Za-z]*$",message = "Must not contain digits or special characters")
    public String city;

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postal_code='" + postal_code + '\'' +
                '}';
    }

    @NotNull(message = "Street name and number")
    @NotEmpty(message = "Street name and number")
    public String street;


    @Transient
    @Field("postalCode")
    public String postal_code;

}
