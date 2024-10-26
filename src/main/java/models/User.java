package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String name;
    private String email;
    private String password;
}
