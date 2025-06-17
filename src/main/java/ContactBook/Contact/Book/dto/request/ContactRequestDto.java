package ContactBook.Contact.Book.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactRequestDto {
    private String id;
    private String name;
    private String email;
    private String phone;
}
