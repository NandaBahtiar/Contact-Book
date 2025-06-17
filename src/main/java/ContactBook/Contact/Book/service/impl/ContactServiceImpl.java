package ContactBook.Contact.Book.service.impl;

import ContactBook.Contact.Book.dto.request.ContactRequestDto;
import ContactBook.Contact.Book.dto.respon.ContactResponDto;
import ContactBook.Contact.Book.entity.Contac;
import ContactBook.Contact.Book.repository.ContactRepository;
import ContactBook.Contact.Book.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactResponDto addContact(ContactRequestDto contactRequestDto) {
        Contac newContact = Contac.builder()
                .name(contactRequestDto.getName())
                .email(contactRequestDto.getEmail())
                .phone(contactRequestDto.getPhone())
                .build();
        contactRepository.save(newContact);
        return toContactResponDto(newContact);
    }

    @Override
    public List<ContactResponDto> findAllContact() {
        return contactRepository.findAll().stream()
                .map(this::toContactResponDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponDto findContactById(String id) {
        Contac contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        return toContactResponDto(contact);
    }

    @Override
    public ContactResponDto updateContact(String id, ContactRequestDto contactRequestDto) {
        Contac existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        existingContact.setName(contactRequestDto.getName());
        existingContact.setEmail(contactRequestDto.getEmail());
        existingContact.setPhone(contactRequestDto.getPhone());
        contactRepository.save(existingContact);
        return toContactResponDto(existingContact);
    }

    @Override
    public void deleteContact(String id) {
        boolean exists = contactRepository.existsById(id);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found");
        }
        contactRepository.deleteById(id);
    }

    private ContactResponDto toContactResponDto(Contac contact) {
        return ContactResponDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }
}