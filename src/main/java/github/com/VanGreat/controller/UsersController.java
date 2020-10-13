package github.com.VanGreat.controller;

import github.com.VanGreat.model.User;
import github.com.VanGreat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/all_users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/all_users/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user_page";
    }

    @PostMapping("/all_users/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "user_page";
    }

    @PostMapping("/all_users/new_user")
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("login") String login,
                             @RequestParam("password") String password) {
        userService.createUser(name, email, login, password);
        return "all_users";
    }

    @GetMapping("/all_users/remove_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "all_users";
    }

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage() {
        return "user";
    }
}
