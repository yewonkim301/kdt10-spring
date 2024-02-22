package codingon.condingonspringboot.controller._00_practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestApiPrac {
    @GetMapping("/introduce/{param1}")
    public String getRes(@PathVariable String param1, Model model) {
        model.addAttribute("name", param1);
        return "_00_practice/restapiPrac";
    }

    @GetMapping("/introduce2")
    public String getRes2(@RequestParam(value="name") String name, @RequestParam(value="age") Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_00_practice/restapiPrac";
    }

    @PostMapping("/post/prac")
    public String postRes(@RequestParam String name, @RequestParam String gender,  @RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer day, @RequestParam String[] hobby, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("hobby", hobby);

        return "_00_practice/restapiPrac";
    }
}
