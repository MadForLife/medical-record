package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "users_id", unique = true, updatable = false, nullable = false,
            columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "users_first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "users_last_name", nullable = false, length = 50)
    private String lastName;
}
