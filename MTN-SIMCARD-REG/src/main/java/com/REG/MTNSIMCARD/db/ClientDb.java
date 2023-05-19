package com.REG.MTNSIMCARD.db;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ClientDb {
    private Long id;
    private String firstname;
    private String lastname;
    private String Email;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

}
