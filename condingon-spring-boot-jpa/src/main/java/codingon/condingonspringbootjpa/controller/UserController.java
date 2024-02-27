package codingon.condingonspringbootjpa.controller;

import codingon.condingonspringbootjpa.dto.UserDTO;
import codingon.condingonspringbootjpa.entity.UserEntity;
import codingon.condingonspringbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    @PostMapping("/insert")
    @ResponseBody
    public String insertUser(@RequestBody UserEntity user) {
        String newName = userService.insertUser(user);
        return newName + " Success";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkName(@RequestParam String name) {
        // name 을 param 으로 받아서 그런 이름을 가진 사용자가 있는지 여부를 return
        boolean result = userService.checkUser(name);
        if (result) return "있습니다.";
        else return "없습니다.";
    }

    @GetMapping("/howManyName")
    @ResponseBody
    public String findName(@RequestParam String name) {
        // name 을 param 으로 받아서 그런 이름을 가진 사용자가 몇 명이나 있는지 확인하여 return
        List<UserEntity> userList = userService.findUser(name);
        return userList.size() + "명";
    }

    @GetMapping("/howManyTotal")
    @ResponseBody
    public String findUser(@RequestParam String name, @RequestParam String nickname) {
        // name 혹은 nickname 을 param 으로 받아서 그런 이름을 가진 사용자가 몇 명이나 있는지 확인하여 return
        List<UserEntity> userList = userService.findUserAll(name, nickname);
        return userList.size() + "명";
    }
}
