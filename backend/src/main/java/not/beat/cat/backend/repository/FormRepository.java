package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    @Query("SELECT form FROM Form form WHERE form.application.id = :applicationId")
    List<Form> findAllByApplicationId(@Param("applicationId") long applicationId);
}
