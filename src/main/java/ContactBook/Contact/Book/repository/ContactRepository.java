package ContactBook.Contact.Book.repository;

import ContactBook.Contact.Book.entity.Contac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contac, String> {

}
