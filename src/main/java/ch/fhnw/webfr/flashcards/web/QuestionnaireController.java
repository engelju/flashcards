package ch.fhnw.webfr.flashcards.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.fhnw.webfr.flashcards.domain.Questionnaire;
import ch.fhnw.webfr.flashcards.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
        return "questionnaires/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String findById(@PathVariable String id, Model model) {
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(id);
        if (questionnaire.isPresent()) {
            model.addAttribute("questionnaire", questionnaire.get());
        }
        return "questionnaires/show";
    }
}
