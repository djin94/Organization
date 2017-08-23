package ru.kabatov.controller;

/**
 * Created by Кабатов on 23.08.2017.
 */
import ru.kabatov.domain.entities.Groups;
import ru.kabatov.service.IGroupsService;
import ru.kabatov.utils.GroupValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroupController {

    @Autowired
    private IGroupsService groupsService;

    Logger log = LoggerFactory.getLogger(GroupController.class);

    GroupValidator groupValidator = new GroupValidator();

    @RequestMapping(value="/group/list.htm", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("groups", groupsService.getAll());
        log.debug("group list");
        return "group/list";
    }

    @RequestMapping(value="/group/add.htm",method=RequestMethod.GET)
    public String add(@ModelAttribute("groupAttribute") Groups group){

        return "group/add";
    }

    @RequestMapping(value = "/group/save.htm", method = RequestMethod.POST)
    public String save(@ModelAttribute("groupAttribute") Groups group, BindingResult result) {
        groupValidator.validate(group, result);
        if (!result.hasErrors()) {
            if (group.getId() == null) {
                log.debug("group save");
                this.groupsService.addEntity(group);
            }
        }
        return "redirect:/group/list.htm";
    }
}