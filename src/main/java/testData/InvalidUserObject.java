package testData;

import lombok.*;
import lombok.experimental.Accessors;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@RequiredArgsConstructor
@NonNull
@Accessors(chain = true)

public class InvalidUserObject extends UserObject {
    private String expectedError;
    private Boolean withBulbError;
    private String fieldWithBulbError;
}
