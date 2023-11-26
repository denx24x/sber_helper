package not.beat.cat.backend.dto;

import lombok.Data;
import not.beat.cat.backend.model.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FormTo {
    private final Long id;
    private final Long applicationId;
    private final String fullName;
    private final LocalDate birthday;
    private final String passportData;
    private final String registrationAddress;
    private final String residentialAddress;
    private final MaritalStatus materialStatus;
    private final Boolean hasChildren;
    private final String workPlace;
    private final Integer workingExperienceInMonth;
    private final String workPosition;
    private final BigDecimal salary;
    private final BigDecimal additionalSalary;
    private final String sourceAdditionalSalary;
    private final BankAccountInfoTo bankAccountInfo;
    private final LocalDateTime creationDate;
    private final LocalDateTime updateDate;
}
