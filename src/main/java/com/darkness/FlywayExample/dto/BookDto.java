package com.darkness.FlywayExample.dto;

import com.darkness.FlywayExample.utils.Utils;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BookDto {
    private Long id;
    @NotBlank(message = "Name " + Utils.MESSAGE_CONSTANT)
    private String name;
    @NotBlank(message = "Type " + Utils.MESSAGE_CONSTANT)
    private String type;
}
