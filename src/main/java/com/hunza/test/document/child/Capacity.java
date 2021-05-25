package com.hunza.test.document.child;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

@Getter
@Setter
public class Capacity {
    @Override
    public String toString() {
        return "Capacity{" +
                "minguest=" + minguest +
                ", maxguest=" + maxguest +
                '}';
    }

    //    minimum number of guests (must not be blank and contains only positive
//            integer value)
//    o maximum number of guests (must not be blank and contains only positive
//            integer value and should not be less than min number of guests
    @NotNull(message = "Min Value is mandatory")
    @Positive(message = "contains only positive integer value")
    @Field("min")
    public int minguest;

    @NotNull(message = "Max Value is mandatory")
    @Positive(message = "contains only positive integer value")
    @Field("max")
    public int maxguest;


}
