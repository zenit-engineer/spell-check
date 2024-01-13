package com.zenit.spellcheck.serviceImpl;

import com.zenit.spellcheck.service.SpellCheckService;
import com.zenit.spellcheck.util.ResponseJsonBody;
import lombok.extern.slf4j.Slf4j;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class SpellCheckServiceImpl implements SpellCheckService{

    @Override
    public ResponseJsonBody spellCheck(String word) {

        //TODO: fullfill validation errors if API is being hit by sending word.length() < 3

        /* dataList - is made for testing purposes, and it is serving as a mini database */
        List<String> dataList = Arrays.asList(

                "përshëndetje",
                "tung",
                "kam",
                "jam",
                "dua",
                "shkoj",
                "luftoj",
                "fushi",
                "fushas",
                "fusha",
                "fushv"

        );

        /* listOfMatchingWords - is the final list that contains the words that are being matched by crossing the ratio */
        TreeMap<String, Integer> mapOfMatchingWords = new TreeMap<>();
        int minimalAssignedRatio = 50;

        for (String element : dataList) {

            int ratio = FuzzySearch.ratio(word, element);

            if (ratio > minimalAssignedRatio) {

                mapOfMatchingWords.put(element, ratio);

            }

        }
        log.info("List of all matching words that crossed assigned ratio {}", mapOfMatchingWords);

        TreeMap<String, Integer> topThreeMap = new TreeMap<>();
        if (mapOfMatchingWords.size() > 3) {

            // Create a new TreeMap with the top three entries
            topThreeMap = mapOfMatchingWords.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            log.info("Final map of three elements to be considered {}", topThreeMap);

        }
        topThreeMap = mapOfMatchingWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);

        // Get a List of the keys from topThreeMap
        List<String> bestMatchingWords = new ArrayList<>(topThreeMap.keySet());
        log.info("List of the best matching words to be returned {}", bestMatchingWords);

        return new ResponseJsonBody(

                HttpStatus.OK,
                "Successfully Retrieved!",
                bestMatchingWords,
                Collections.emptyList()

        );


    }


}



