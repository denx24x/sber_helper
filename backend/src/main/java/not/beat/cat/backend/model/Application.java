package not.beat.cat.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
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

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    @Column(name = "forms")
    private List<Form> forms;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
