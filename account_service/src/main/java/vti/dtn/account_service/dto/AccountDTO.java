package vti.dtn.account_service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class AccountDTO {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
}
