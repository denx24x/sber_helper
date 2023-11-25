package not.beat.cat.backend.transformer;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import not.beat.cat.backend.dto.ApplicationTo;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Form;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

        return application;
    }

    public ApplicationTo transform(Application application) {
        return new ApplicationTo(
                application.getId(),
                application.getAmount(),
                application.getTermMonths(),
                application.getInterest(),
                application.getProduct(),
                application.getCreationDate(),
                application.getStatus()
        );
    }
}
