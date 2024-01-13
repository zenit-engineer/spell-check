package com.zenit.spellcheck.repository;

import com.zenit.spellcheck.model.AlbanianDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SpellCheckRepository extends JpaRepository<AlbanianDictionary, BigInteger > {
}
