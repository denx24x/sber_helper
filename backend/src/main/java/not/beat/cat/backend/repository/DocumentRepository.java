package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("SELECT doc FROM Document doc WHERE doc.form.id = :formId")
    List<Document> findAllByFormId(@Param("formId") long formId);
}
