package com.capgemini.addressbookapp.services;

import java.util.List;

import com.capgemini.addressbookapp.dto.ContactDTO;
import com.capgemini.addressbookapp.exceptions.AddressBookException;
import com.capgemini.addressbookapp.model.ContactData;

public interface IAddressBookService {

	List<ContactData> getAllContacts();

	ContactData getContactById(int contactId) throws AddressBookException;

	ContactData addContactInBook(ContactDTO contactDto);

	ContactData updateContactInBookById(int contactId, ContactDTO contactDto) throws AddressBookException;

	void deleteContactInBookById(int contactId) throws AddressBookException;

}
