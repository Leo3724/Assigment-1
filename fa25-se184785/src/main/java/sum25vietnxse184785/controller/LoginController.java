package sum25vietnxse184785.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sum25vietnxse184785.pojo.SonyAccount;
import sum25vietnxse184785.service.SonyAccountService;

@Controller
public class LoginController {

    @Autowired
    private SonyAccountService accountService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {

        SonyAccount account = accountService.login(phone, password);

        if (account == null) {
            model.addAttribute("error", "Invalid phone or password");
            return "login";
        }


        if (account.getRoleID() != 1 && account.getRoleID() != 2) {
            model.addAttribute("error", "You do not have permission to access this function!");
            return "login";
        }

        session.setAttribute("loggedUser", account);
        return "redirect:/products";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

