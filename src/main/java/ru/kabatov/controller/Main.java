package ru.kabatov.controller;
import ru.kabatov.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(new String[] {"/web/WEB-INF/dispatcher-servlet.xml"});
        IUserService iuser =  (IUserService)context.getBean("userService"); // имя бина должно быть с маленькой буквы
        System.out.println("count of users:"+iuser.getAll().size());
    }
}
