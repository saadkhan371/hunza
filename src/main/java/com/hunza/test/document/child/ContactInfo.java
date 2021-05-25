package com.hunza.test.document.child;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactInfo {

    @Override
    public String toString() {
        return "ContactInfo{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Field("phone")
    public String phoneNumber;

    @NotNull(message= "MobileNo is mandatory")
    @NotEmpty(message= "MobileNo is mandatory")
    @Field("mobile")
    public String mobileNumber;

    @Email(message = "Email should be valid")
    @Field("email")
    public String email;


}
