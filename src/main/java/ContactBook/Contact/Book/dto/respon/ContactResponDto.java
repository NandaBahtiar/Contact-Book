package ContactBook.Contact.Book.dto.respon;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactResponDto {

    private String id;
    private String name;
    private String email;
    private String phone;
}
