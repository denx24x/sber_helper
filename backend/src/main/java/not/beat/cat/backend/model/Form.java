package not.beat.cat.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "forms")
public class Form {
    @Id
    @GeneratedValue
    @Column(name = "form_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "passport_data")
    private String passportData;

    @OneToMany(mappedBy = "form", fetch = FetchType.LAZY)
    private List<Document> documents;

    @Column(name = "registration_address")
    private String registrationAddress;

    @Column(name = "residential_address")
    private String residentialAddress;

    @Enumerated
    @Column(name = "material_status")
    private MaritalStatus materialStatus;

    @Column(name = "has_children")
    private boolean hasChildren;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "working_experience_in_month")
    private Integer workingExperienceInMonth;

    @Column(name = "work_position")
    private String workPosition;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "additional_salary")
    private BigDecimal additionalSalary;

    @Column(name = "source_additional_salary")
    private String sourceAdditionalSalary;

    @OneToOne(mappedBy = "form", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private BankAccountInfo bankAccountInfo;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
