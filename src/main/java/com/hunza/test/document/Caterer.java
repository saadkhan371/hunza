package com.hunza.test.document;

import com.hunza.test.document.child.Capacity;
import com.hunza.test.document.child.ContactInfo;
import com.hunza.test.document.child.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "caterer")
public class Caterer {
    @Id
    public String Id;

    @Field("name")
    @NotEmpty(message = "name can not be empty.")
    @Size(max = 100, message = "name can not be more than 100 characters.")
    public String name;

    @Override
    public String toString() {
        return "Caterer{" +
                "id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", capacity=" + capacity +
                ", contactInfo=" + contactInfo +
                '}';
    }

    @NotNull
    @Valid
    @Field("location")
    public Location location;

    @NotNull
    @Valid
    @Field("capacity")
    public Capacity capacity;

    @NotNull
    @Valid
    @Field("contactInfo")
    public ContactInfo contactInfo;
}
