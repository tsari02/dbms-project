package com.dbms.project.service;

import com.dbms.project.dao.ContactFormDao;
import com.dbms.project.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormService {
    private final ContactFormDao contactFormDao;
    
    @Autowired
    public ContactFormService(ContactFormDao contactFormDao) {
        this.contactFormDao = contactFormDao;
    }

    public int insertContactForm(ContactForm contactForm) {
        return contactFormDao.insertContactForm(contactForm);
    }

    public List<ContactForm> getAllContactForms() {
        return contactFormDao.getAllContactForms();
    }

    public ContactForm getContactFormById(int id) {
        return contactFormDao.getContactFormById(id);
    }

    public int deleteContactForm(int id) {
        return contactFormDao.deleteContactForm(id);
    }

    public int updateContactForm(int id, ContactForm contactForm) {
        return contactFormDao.updateContactForm(id, contactForm);
    }
}
