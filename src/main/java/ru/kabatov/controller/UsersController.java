package ru.kabatov.controller;

/**
 * Created by Кабатов on 22.08.2017.
 */
import ru.kabatov.config.UserSettings;
import ru.kabatov.service.IGroupsService;
import ru.kabatov.service.IUserService;
import ru.kabatov.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value="/user")
public class UsersController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGroupsService groupsService;
    @Autowired
    private UserSettings userSettings;

    Logger log = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(value="/index.htm", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("groups", groupsService.getAll());
        model.addAttribute("positions", positionService.getAll());
        model.addAttribute("users", userService.getAll());
        log.debug("xxx debug");
        userSettings.loadSettings();
        log.debug("user settings :{}, {}", userSettings.getCountry(), userSettings.getLanguage());
        return "user/list";
    }

    @RequestMapping(value="addajax.htm",method=RequestMethod.POST)
    public @ResponseBody String add(@RequestParam(value = "username", required = true) String username,
                                    @RequestParam(value = "positionid", required = true) Integer positionid,
                                    @RequestParam(value = "groupid", required = true) Integer groupid ){
        String returnText;

        if(!username.isEmpty()){
            userService.addEntity(username, groupid, positionid);
            returnText = "User has been added to the list. Total number of users are: " +username+";posid = "+positionid+";grid="+groupid;
        }else{
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return returnText;
    }

    @RequestMapping(value="/deleteajax.htm",method=RequestMethod.POST)
    public @ResponseBody String delete(@RequestParam(value = "userid", required = true) Integer userid ){
        String returnText;
        if(userid.intValue() != 0){
            userService.deleteEntity(userid);
            returnText = "deleted: " +userid;
        }else{
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return returnText;
    }

}