package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findAll();

    Form save(Form form);
}
