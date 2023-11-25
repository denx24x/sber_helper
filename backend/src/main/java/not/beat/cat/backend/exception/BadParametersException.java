package not.beat.cat.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadParametersException extends ApiException {
    private final BindingResult bindingResult;

    public BadParametersException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }
}
