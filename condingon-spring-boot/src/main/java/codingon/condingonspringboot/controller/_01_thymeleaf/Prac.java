package codingon.condingonspringboot.controller._01_thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Prac {
    @GetMapping("/prac")
    public String getPrac(Model model) {
        // 실습1
        model.addAttribute("age", 8);
        model.addAttribute("age2", 22);

        // 실습2
        List<Person> people  = new ArrayList<Person>();
        people.add(new Person("kim", 10));
        people.add(new Person("lee", 20));
        people.add(new Person("hong", 30));
        people.add(new Person("park", 40));
        people.add(new Person("shin", 50));
        model.addAttribute("people", people);


        return "_01_thymeleaf/prac";
    }
}

@Getter
@Setter
@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자
class Person {
    private String name;
    private int age;
}
