package not.beat.cat.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "formId")
    private long formId;

    @Column(name = "type")
    private DocumentType type;

    @Column(name = "location")
    private String location;
}
