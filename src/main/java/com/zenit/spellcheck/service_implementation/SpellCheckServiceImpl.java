package com.zenit.spellcheck.service_implementation;

import com.zenit.spellcheck.enums.SpellCheckResponse;
import com.zenit.spellcheck.repository.SpellCheckRepository;
import com.zenit.spellcheck.service.SpellCheckService;
import com.zenit.spellcheck.util.ResponseJsonBody;
import com.zenit.spellcheck.util.ValidationErrors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpellCheckServiceImpl implements SpellCheckService{

    private final SpellCheckRepository spellCheckRepository;

    @Override
    public ResponseJsonBody spellCheck(String key, String language, String word) {

        List<String> validationErrors = checkValidations(key, language, word);

        if (!validationErrors.isEmpty()){

            return new ResponseJsonBody(
                    HttpStatus.BAD_REQUEST,
                    SpellCheckResponse.RESTRUCTURE_YOU_REQUEST.getMessage(),
                    new ArrayList<>(),
                    validationErrors
            );

        }

//        else if (!ip.equals("0:0:0:0:0:0:0:1")) {
//
//            return new ResponseJsonBody(
//                    HttpStatus.FORBIDDEN,
//                    SpellCheckResponse.YOU_ARE_NOT_ALLOWED_TO_ACCESS_THIS_API.getMessage(),
//                    new ArrayList<>(),
//                    new ArrayList<>()
//            );
//
//        }

        List<String> bestMatchingWords = spellCheckRepository.findWordBySimilarityScore(word);

        return new ResponseJsonBody(

                HttpStatus.OK,
                SpellCheckResponse.SUCCESSFULLY_RETRIEVED.getMessage(),
                bestMatchingWords,
                new ArrayList<>()

        );

    }

    private static List<String> checkValidations(String key, String language, String word) {

        List<String> validationErrors = new ArrayList<>();

        boolean isValidString = ValidationErrors.isValidString(word);

        if (word == null || word.equals("") || !isValidString){

            validationErrors.add(SpellCheckResponse.WORD_MUST_CONTAIN_ONLY_LETTERS.getMessage());

        }else if (word.length() < 3){

            validationErrors.add(SpellCheckResponse.WORD_MUST_HAVE_MORE_THAN_TWO_LETTERS.getMessage());

        } else if (key == null || !key.equals("2001")) {

            validationErrors.add(SpellCheckResponse.WRONG_KEY.getMessage());

        } else if (
                language == null ||
                (!language.equalsIgnoreCase("EN")
                && !language.equalsIgnoreCase("FR")
                && !language.equalsIgnoreCase("DE")
                && !language.equalsIgnoreCase("SP"))) {

            validationErrors.add(SpellCheckResponse.INVALID_LANGUAGE.getMessage());

        }

        return validationErrors;
    }

}



