package not.beat.cat.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import not.beat.cat.backend.model.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FormCreateRequest {
    @NotNull
    private final Long applicationId;

    @NotBlank
    private final String fullName;

    @Past
    private final LocalDate birthday;

    @Pattern(regexp = "^[0-9]{4} [0-9]{6}$")
    private final String passportData;

    @NotBlank
    private final String registrationAddress;

    @NotBlank
    private final String residentialAddress;

    @NotNull
    private final MaritalStatus materialStatus;

    @NotNull
    private final Boolean hasChildren;

    @NotBlank
    private final String workPlace;

    @Min(0)
    private final Integer workingExperienceInMonths;

    @NotBlank
    private final String workPosition;

    @Min(0)
    private final BigDecimal salary;

    @Min(0)
    private final BigDecimal additionalSalary;

    @NotBlank
    private final String sourceAdditionalSalary;
}
