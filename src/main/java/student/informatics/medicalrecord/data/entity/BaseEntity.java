package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "CHAR(36)", nullable = false, updatable = false, unique = true)
    private String id;

//    @CreationTimestamp(source = SourceType.DB)
//    @Column(name = "created_at")
//    private Instant createdAt;
//
//    @UpdateTimestamp(source = SourceType.DB)
//    @Column(name = "updated_at")
//    private Instant updatedAt;
}
