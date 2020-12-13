package com.capgemini.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.addressbookapp.model.ContactData;

public interface AddressBookRepository extends JpaRepository<ContactData, Integer> {

}
