package ContactBook.Contact.Book.dto.respon;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponDto<T> {
    private String message;
    private HttpStatus status;
    private int statusCode;
    private T data;
}
