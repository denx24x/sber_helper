package not.beat.cat.backend.controller;

import not.beat.cat.backend.model.Form;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {

    @GetMapping
    public List<Form> findForms(
            @PathVariable(value = "offset", required = false) int offset,
            @PathVariable(value = "limit", required = false) int limit
    ) {
        return null;
    }
}
