package com.zenit.spellcheck.repository;

import com.zenit.spellcheck.model.AlbanianDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface SpellCheckRepository extends JpaRepository<AlbanianDictionary, BigInteger > {

    @Query(value = """
            SELECT a.word
            FROM albanian_dictionary a
            WHERE similarity(a.word, :word) > 0.1
            ORDER BY similarity(a.word, :word) DESC
            LIMIT 3
            """, nativeQuery = true)
    List<String> findWordBySimilarityScore(@Param("word") String word);

}
