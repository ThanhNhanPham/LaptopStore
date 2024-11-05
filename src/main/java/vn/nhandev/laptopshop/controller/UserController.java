package vn.nhandev.laptopshop.controller;

import vn.nhandev.laptopshop.domain.User;
import vn.nhandev.laptopshop.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.nhandev.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;


    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers=this.userService.getAllUsersbyEmail("3@gmail.com");
        System.out.print(arrUsers);
        model.addAttribute("nhan", "test");
        model.addAttribute("hoidanit", "toi la nhan");
        return "hello";
    }
    @RequestMapping("/admin/user")// GET
    public String getUserPage1(Model model) {
        return "admin/user/design";
    }

    @RequestMapping("/admin/user/create")// GET
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value="/admin/user/create1", method = RequestMethod.POST)// GET
    public String createUserPage(Model model,@ModelAttribute("newUser") User hoidanit) {
        System.out.println("run here" + hoidanit);
        this.userService.handleSaveUser(hoidanit);
        return "hello";
    }

}
