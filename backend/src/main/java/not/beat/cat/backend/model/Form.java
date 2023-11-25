package not.beat.cat.backend.model;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.w3c.dom.DocumentType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Data
public class Form {
    private final long id;
    private final FormStatus status;
    private final String fullName;
    private final LocalDate birthday;
    private final String passportData;
    private final List<Document> documents;
    private final String registrationAddress;
    private final String residentialAddress;
    private final MaritalStatus maritalStatus;
    private final boolean hasChildren;
    private final String workPlace;
    private final Duration workingExperience;
    private final String workPosition;
    private final BigDecimal salary;
    private final BigDecimal additionalSalary;
    private final String sourceAdditionalSalary;
    private final BankAccountInfo bankAccountInfo;
}
