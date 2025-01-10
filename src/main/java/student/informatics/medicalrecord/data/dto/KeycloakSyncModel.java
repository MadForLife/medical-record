package student.informatics.medicalrecord.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

record Role(String name) {}

@NoArgsConstructor
@Getter @Setter
public class KeycloakSyncModel {

    private String id;
    private String firstName;
    private String lastName;
    private String personalIdentificationNumber;
    private List<Role> roles;
}
