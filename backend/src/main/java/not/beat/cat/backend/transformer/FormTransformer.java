package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.FormCreateRequest;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.model.Form;
import org.springframework.stereotype.Component;

@Component
public class FormTransformer {
    private final BankAccountTransformer bankAccountTransformer;

    public FormTransformer(BankAccountTransformer bankAccountTransformer) {
        this.bankAccountTransformer = bankAccountTransformer;
    }

    public Form transform(FormTo formTo) {
        Form form = new Form();
        form.setId(formTo.getId());
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
        form.setCreationDate(formTo.getCreationDate());
        form.setUpdateDate(formTo.getUpdateDate());

        return form;
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
        form.setWorkingExperience(createRequest.getWorkingExperience());
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
                form.getWorkingExperience(),
                form.getWorkPosition(),
                form.getSalary(),
                form.getAdditionalSalary(),
                form.getSourceAdditionalSalary(),
                bankAccountTransformer.transform(form.getBankAccountInfo()),
                form.getCreationDate(),
                form.getUpdateDate()
        );
    }
}
