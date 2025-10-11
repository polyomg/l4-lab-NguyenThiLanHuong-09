package poly.edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OkController {

    // Link: http://localhost:8080/ok
    @GetMapping("/ok")
    public String ok() {
        return "Lab2/ok";
    }

    @PostMapping(value = "/ctrl/ok", params = "!x")
    public String m1(Model model) {
        model.addAttribute("method", "m1");
        return "Lab2/ok";
    }

    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2");
        return "Lab2/ok";
    }

    @PostMapping(value = "/ctrl/ok/{x}")
    public String m3(@PathVariable("x") Integer x, Model model) {
        model.addAttribute("method", "m3: x=" + x);
        return "Lab2/ok";
    }
}
