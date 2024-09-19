package com.sboard.controller;

import com.sboard.dto.UserDTO;
import com.sboard.service.TermsService;
import com.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    private final TermsService termsService;

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO) {

        userService.insertUser(userDTO);

        return "redirect:/user/login";

    }

    @GetMapping("/user/terms")
    public String terms(Model model) {

        String terms = termsService.getTerms();
        String privacyPolicy = termsService.getPrivacy();

        model.addAttribute("terms", terms);
        model.addAttribute("privacy", privacyPolicy);

        return "/user/terms";
    }

    @GetMapping("/user/checkUser.do")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkUser(
            @RequestParam String type, @RequestParam String value) {

        Map<String, Object> response = new HashMap<>();
        boolean isAvailable;

        switch (type) {
            case "uid":
                isAvailable = userService.isUserIdAvailable(value);
                break;
            case "nick":
                isAvailable = userService.isNicknameAvailable(value);
                break;
            case "email":
                isAvailable = userService.isEmailAvailable(value);
                break;
            case "hp":
                isAvailable = userService.isPhoneNumberAvailable(value);
                break;
            default:
                isAvailable = false;
                break;
        }

        response.put("result", isAvailable ? 0 : 1); // 0: 사용 가능, 1: 사용 중
        return ResponseEntity.ok(response);
    }


}



