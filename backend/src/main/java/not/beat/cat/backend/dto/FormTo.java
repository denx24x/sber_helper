package not.beat.cat.backend.dto;

import lombok.Data;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.MaritalStatus;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

@Data
public class FormTo {
    private final Long id;
    private final String fullName;
    private final LocalDate birthday;
    private final String passportData;
    private final String registrationAddress;
    private final String residentialAddress;
    private final MaritalStatus materialStatus;
    private final Boolean hasChildren;
    private final String workPlace;
    private final Duration workingExperience;
    private final String workPosition;
    private final BigDecimal salary;
    private final BigDecimal additionalSalary;
    private final String sourceAdditionalSalary;
    private final BankAccountInfoTo bankAccountInfo;
}
