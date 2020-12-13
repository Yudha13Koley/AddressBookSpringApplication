package com.capgemini.addressbookapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.addressbookapp.dto.ContactDTO;
import com.capgemini.addressbookapp.model.ContactData;
import com.capgemini.addressbookapp.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBook;

	@Override
	public List<ContactData> getAllContacts() {
		return addressBook.findAll();
	}

	@Override
	public ContactData getContactById(int contactId) {
		return addressBook.findById(contactId).get();
	}

	@Override
	public ContactData addContactInBook(ContactDTO contactDto) {
		ContactData contactData = null;
		contactData = new ContactData(contactDto);
		addressBook.save(contactData);
		return contactData;
	}

	@Override
	public ContactData updateContactInBookById(int contactId, ContactDTO contactDto) {
		ContactData contactData = this.getContactById(contactId);
		contactData.setFullName(contactDto.fullName);
		contactData.setPhoneNo(contactDto.phoneNo);
		contactData.setAddress(contactDto.address);
		contactData.setCity(contactDto.city);
		contactData.setState(contactDto.state);
		contactData.setZip(contactDto.zip);
		addressBook.save(contactData);
		return contactData;
	}

	@Override
	public void deleteContactInBookById(int contactId) {
		addressBook.deleteById(contactId);
	}

}