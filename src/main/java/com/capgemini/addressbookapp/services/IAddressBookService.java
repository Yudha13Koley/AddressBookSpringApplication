package com.capgemini.addressbookapp.services;

import java.util.List;

import com.capgemini.addressbookapp.dto.ContactDTO;
import com.capgemini.addressbookapp.model.ContactData;

public interface IAddressBookService {

	List<ContactData> getAllContacts();

	ContactData getContactById(int contactId);

	ContactData addContactInBook(ContactDTO contactDto);

	ContactData updateContactInBookById(int contactId, ContactDTO contactDto);

	void deleteContactInBookById(int contactId);

}
