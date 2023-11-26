package not.beat.cat.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "term_months")
    private int termMonths;

    @Column(name = "interest")
    private BigDecimal interest;

    @Column(name = "product")
    private String product;

    @Enumerated
    @Column(name = "status")
    private ApplicationStatus status;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<Form> forms;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
