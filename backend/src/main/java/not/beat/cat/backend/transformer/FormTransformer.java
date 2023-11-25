package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.BankAccountInfoTo;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.model.FormStatus;
import not.beat.cat.backend.model.MaritalStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

@Component
public class FormTransformer {
    private final BankAccountTransformer bankAccountTransformer;

    public FormTransformer(BankAccountTransformer bankAccountTransformer) {
        this.bankAccountTransformer = bankAccountTransformer;
    }

    public Form transform(FormTo formTo) {
        Form form = new Form();
        form.setId(formTo.getId());
        form.setStatus(formTo.getStatus());
        form.setFullName(formTo.getFullName());
        form.setBirthday(formTo.getBirthday());
        form.setPassportData(formTo.getPassportData());
        form.setRegistrationAddress(formTo.getRegistrationAddress());
        form.setResidentialAddress(formTo.getResidentialAddress());
        form.setMaterialStatus(formTo.getMaterialStatus());
        form.setHasChildren(formTo.getHasChildren());
        form.setWorkPlace(formTo.getWorkPlace());
        form.setWorkingExperience(formTo.getWorkingExperience());
        form.setWorkPosition(formTo.getWorkPosition());
        form.setSalary(formTo.getSalary());
        form.setAdditionalSalary(formTo.getAdditionalSalary());
        form.setSourceAdditionalSalary(formTo.getSourceAdditionalSalary());
        form.setBankAccountInfo(bankAccountTransformer.transform(
                formTo.getBankAccountInfo()
        ));

        return form;
    }

    public FormTo transform(Form form) {
        return new FormTo(
            form.getId(),
            form.getStatus(),
            form.getFullName(),
            form.getBirthday(),
            form.getPassportData(),
            form.getRegistrationAddress(),
            form.getResidentialAddress(),
            form.getMaterialStatus(),
            form.isHasChildren(),
            form.getWorkPlace(),
            form.getWorkingExperience(),
            form.getWorkPosition(),
            form.getSalary(),
            form.getAdditionalSalary(),
            form.getSourceAdditionalSalary(),
            bankAccountTransformer.transform(form.getBankAccountInfo())
        );
    }
}
