package ch.fhnw.webfr.flashcards.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:questionnaires";
    }
}
