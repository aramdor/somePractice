package testData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NonNull
@Accessors(chain = true)
public class UserObject {
    public String login;
    private String password;
    private String passwordConfirmation;
    private Boolean forcePasswordChangeCheckbox;
    private String fullName;
    private String email;
    private String jabber;

}
