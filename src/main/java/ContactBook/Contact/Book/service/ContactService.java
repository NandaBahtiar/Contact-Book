package ContactBook.Contact.Book.service;

import ContactBook.Contact.Book.dto.request.ContactRequestDto;
import ContactBook.Contact.Book.dto.respon.ContactResponDto;

import java.util.List;

public interface ContactService {
    ContactResponDto addContact(ContactRequestDto ContactRequestDto);
    List<ContactResponDto> findAllContact();
    ContactResponDto findContactById(String id);
    ContactResponDto updateContact(String id, ContactRequestDto contactRequestDto);
    void deleteContact(String id);

}