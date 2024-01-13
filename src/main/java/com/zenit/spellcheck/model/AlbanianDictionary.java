package com.zenit.spellcheck.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "albanian_dictionary")
public class AlbanianDictionary {

    @Column(name = "id")
    @Id
    private BigInteger id;

    @Column(name = "word")
    private String word;

}
