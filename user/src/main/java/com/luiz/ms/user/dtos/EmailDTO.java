package com.luiz.ms.user.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class EmailDTO {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
