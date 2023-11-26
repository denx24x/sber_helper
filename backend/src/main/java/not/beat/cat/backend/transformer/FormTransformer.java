package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.FormCreateRequest;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.model.Form;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
public class FormTransformer {
    private final BankAccountInfoTransformer bankAccountInfoTransformer;

    public FormTransformer(BankAccountInfoTransformer bankAccountInfoTransformer) {
        this.bankAccountInfoTransformer = bankAccountInfoTransformer;
    }

    public Form transform(FormCreateRequest createRequest) {
        Form form = new Form();
        form.setFullName(createRequest.getFullName());
        form.setBirthday(createRequest.getBirthday());
        form.setPassportData(createRequest.getPassportData());
        form.setRegistrationAddress(createRequest.getRegistrationAddress());
        form.setResidentialAddress(createRequest.getResidentialAddress());
        form.setMaterialStatus(createRequest.getMaterialStatus());
        form.setHasChildren(createRequest.getHasChildren());
        form.setWorkPlace(createRequest.getWorkPlace());
        form.setWorkingExperience(Duration.of(createRequest.getWorkingExperienceInMonths(), ChronoUnit.MONTHS));
        form.setWorkPosition(createRequest.getWorkPosition());
        form.setSalary(createRequest.getSalary());
        form.setAdditionalSalary(createRequest.getAdditionalSalary());
        form.setSourceAdditionalSalary(createRequest.getSourceAdditionalSalary());

        return form;
    }

    public FormTo transform(Form form) {
        return new FormTo(
                form.getId(),
                form.getApplication().getId(),
                form.getFullName(),
                form.getBirthday(),
                form.getPassportData(),
                form.getRegistrationAddress(),
                form.getResidentialAddress(),
                form.getMaterialStatus(),
                form.isHasChildren(),
                form.getWorkPlace(),
                (int) form.getWorkingExperience().get(ChronoUnit.MONTHS),
                form.getWorkPosition(),
                form.getSalary(),
                form.getAdditionalSalary(),
                form.getSourceAdditionalSalary(),
                bankAccountInfoTransformer.transform(form.getBankAccountInfo()),
                form.getCreationDate(),
                form.getUpdateDate()
        );
    }
}
