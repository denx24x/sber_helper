package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.ApplicationCreateRequest;
import not.beat.cat.backend.dto.ApplicationTo;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import org.springframework.stereotype.Component;

@Component
public class ApplicationTransformer {

    public Application transform(ApplicationTo applicationTo) {
        Application application = new Application();
        application.setId(applicationTo.getId());
        application.setAmount(applicationTo.getAmount());
        application.setTermMonths(applicationTo.getTermMonths());
        application.setInterest(applicationTo.getInterest());
        application.setProduct(applicationTo.getProduct());
        application.setCreationDate(applicationTo.getCreationDate());
        application.setStatus(applicationTo.getStatus());
        application.setCreationDate(applicationTo.getCreationDate());
        application.setUpdateDate(applicationTo.getUpdateDate());

        return application;
    }

    public Application transform(ApplicationCreateRequest createRequest) {
        Application application = new Application();
        application.setAmount(createRequest.getAmount());
        application.setTermMonths(createRequest.getTermMonths());
        application.setInterest(createRequest.getInterest());
        application.setProduct(createRequest.getProduct());
        application.setStatus(ApplicationStatus.NEW);

        return application;
    }

    public ApplicationTo transform(Application application) {
        return new ApplicationTo(
                application.getId(),
                application.getAmount(),
                application.getTermMonths(),
                application.getInterest(),
                application.getProduct(),
                application.getStatus(),
                application.getCreationDate(),
                application.getUpdateDate()
        );
    }
}
