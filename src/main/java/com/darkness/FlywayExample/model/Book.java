package com.darkness.FlywayExample.model;

import com.darkness.FlywayExample.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name " + Utils.MESSAGE_CONSTANT)
    @UniqueElements
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotBlank(message = "type " + Utils.MESSAGE_CONSTANT)
    private BookType type;
}
