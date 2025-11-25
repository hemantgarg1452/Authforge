package in.project.authforge.io;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "name should be not empty")
    private String name;
    @NotNull(message = "email should be not empty")
    @Email(message = "Enter valid email address")
    private String email;
    @Size(min = 8, message = "password must be atleast 6 characters")
    private String password;
}
