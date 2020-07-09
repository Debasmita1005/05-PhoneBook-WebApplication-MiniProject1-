package com.pbw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbw.dto.Contact;
import com.pbw.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/addContact")
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact",c);
		return "contactInfo";
	}
	
	@PostMapping(value = "/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, Model model) {
		boolean isSave = contactService.saveContact(c);
		if(isSave) {
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg", "Failed to save Contact");
		}
		return "contactInfo";
	}
	
	@GetMapping("/viewContacts")
	public String handleViewContactsLink(Model model) {
		List<Contact> contactsList  = contactService.getAllContacts();
		model.addAttribute("contacts", contactsList);
		return "viewContacts";
	}
}
