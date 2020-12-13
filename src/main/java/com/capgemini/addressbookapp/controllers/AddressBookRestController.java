package com.capgemini.addressbookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.addressbookapp.dto.ContactDTO;
import com.capgemini.addressbookapp.dto.ResponseDTO;
import com.capgemini.addressbookapp.model.ContactData;
import com.capgemini.addressbookapp.services.IAddressBookService;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookRestController {

	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookContacts() {
		List<ContactData> contactDatalist = null;
		contactDatalist = addressBookService.getAllContacts();
		ResponseDTO response = new ResponseDTO("Get Call Successful !", contactDatalist);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddressBookContactById(@PathVariable("contactId") int contactId) {
		ContactData contactData = null;
		contactData = addressBookService.getContactById(contactId);
		ResponseDTO response = new ResponseDTO("Get Call Successful for Id : " + contactId, contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContactInBook(@RequestBody ContactDTO contactDto) {
		ContactData contactData = null;
		contactData = addressBookService.addContactInBook(contactDto);
		ResponseDTO response = new ResponseDTO("Created Contact Successfully !", contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactInBook(@PathVariable("contactId") int contactId,
			@RequestBody ContactDTO contactDto) {
		ContactData contactData = null;
		contactData = addressBookService.updateContactInBookById(contactId, contactDto);
		ResponseDTO response = new ResponseDTO("Updated Contact Successfully ! contact Id : " + contactId, contactData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookContactById(@PathVariable("contactId") int contactId) {
		addressBookService.deleteContactInBookById(contactId);
		ResponseDTO response = new ResponseDTO("Deleted Successfully !",
				"Deleted id : " + contactId + " Successfully !");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

}
