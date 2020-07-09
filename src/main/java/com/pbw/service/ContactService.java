package com.pbw.service;

import java.util.List;

import com.pbw.dto.Contact;


public interface ContactService {
	boolean saveContact(Contact c);
	List<Contact> getAllContacts();
	Contact getContactById(Integer cid);
	boolean updateContact(Contact c);
	boolean deleteContact(Integer cid);
}
