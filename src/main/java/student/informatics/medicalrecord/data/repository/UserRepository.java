package student.informatics.medicalrecord.data.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student.informatics.medicalrecord.data.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into users (users_id, users_first_name, users_last_name) values (:userId, :firstName, :lastName)", nativeQuery = true)
    void insertUser(@Param("userId") String id,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName);
}
