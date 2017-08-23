package ru.kabatov.utils;

/**
 * Created by Кабатов on 23.08.2017.
 */
import ru.kabatov.domain.entities.Groups;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GroupValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Groups.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Groups group = (Groups) o;
        if(group.getTitle().trim().equals("")){
            errors.rejectValue("title", "title.required");
        }
    }
}