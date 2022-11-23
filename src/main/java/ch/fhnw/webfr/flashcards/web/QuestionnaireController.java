package ch.fhnw.webfr.flashcards.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.fhnw.webfr.flashcards.domain.Questionnaire;
import ch.fhnw.webfr.flashcards.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireRepository repository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
		model.addAttribute("questionnaires", repository.findAll());
        return "questionnaires/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable String id, Model model) {
        Optional<Questionnaire> questionnaire = repository.findById(id);
        if (questionnaire.isPresent()) {
            model.addAttribute("questionnaire", questionnaire.get());
            return "questionnaires/show";
        }
		return "errors/404";
    }

    @RequestMapping(method = RequestMethod.GET, params = { "form" })
    public String getCreateForm(Model model) {
        model.addAttribute("questionnaire", new Questionnaire());
        return "questionnaires/create";
    }

    @RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Questionnaire questionnaire, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("questionnaire", questionnaire);
            return "questionnaires/create";
        }
		repository.save(questionnaire);
		return "redirect:/questionnaires";
	}

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "redirect:/questionnaires";
        }
        return "errors/404";
    }
}
