package com.dbms.project.api;

import com.dbms.project.model.ContactForm;
import com.dbms.project.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("/api/contact")
@Controller
public class ContactFormController {
    private final ContactFormService contactFormService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @PostMapping(path="/api/contact")
    @ResponseBody
    public void addContactForm(@Valid @NotNull @RequestBody ContactForm contactForm) {
        contactFormService.insertContactForm(contactForm);
    }

    @GetMapping(path="/api/contact")
    @ResponseBody
    public List<ContactForm> getAllContactForms() {
        return contactFormService.getAllContactForms();
    }

    @PostMapping(path="/api/contact/{id}/delete")
    @ResponseBody
    public void deleteContactForm(@PathVariable("id") int id) {
        contactFormService.deleteContactForm(id);
    }

    @GetMapping(path="/api/contact/{id}")
    @ResponseBody
    public ContactForm getContactFormById(@PathVariable("id") int id) {
        return contactFormService.getContactFormById(id);
    }

    @PostMapping(path="/api/contact/{id}/edit")
    @ResponseBody
    public void updateContactForm(@PathVariable("id") int id, @Valid @NotNull @RequestBody ContactForm contactForm) {
        contactFormService.updateContactForm(id, contactForm);
    }
}
