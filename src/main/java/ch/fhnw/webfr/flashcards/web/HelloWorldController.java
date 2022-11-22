package ch.fhnw.webfr.flashcards.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.fhnw.webfr.flashcards.domain.Questionnaire;
import ch.fhnw.webfr.flashcards.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private QuestionnaireRepository repository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name) {
        List<Questionnaire> questionnaire = repository.findAll();

        String html = "Hello, " + name + "</br>" + "You have " + questionnaire.size() + " questionnaries in your repo.";

        return html;
    }
}
