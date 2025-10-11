package poly.edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ResultController {

    //Link: http

    @RequestMapping("/a")
    public String m1() {
        return "Lab2/a";
    }

    @RequestMapping("/b")
    public String m2(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "I come from b");
        return "redirect:/a";
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";
    }

    @RequestMapping("/d")
    public String m4() {
        return "Lab2/d";
    }

}
