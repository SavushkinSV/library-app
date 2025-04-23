package ssv.home.project1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssv.home.project1.model.Person;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ssv.home.project1.service.PersonService;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personService.findByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "Читатель уже зарегистрирован.");
        }
    }
}
