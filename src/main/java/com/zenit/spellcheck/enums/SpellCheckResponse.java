package com.zenit.spellcheck.enums;

import lombok.Getter;

@Getter
public enum SpellCheckResponse{

    SUCCESSFULLY_RETRIEVED("Successfully Retrieved!"),
    WORD_MUST_HAVE_MORE_THAN_TWO_LETTERS("Word must have more than two letters!"),
    WORD_MUST_CONTAIN_ONLY_LETTERS("Word must contain only letters!"),
    WRONG_KEY("Wrong key within your request!"),
    INVALID_LANGUAGE("Invalid Language!"),
    YOU_ARE_NOT_ALLOWED_TO_ACCESS_THIS_API("You are not allowed to access this API!"),
    RESTRUCTURE_YOU_REQUEST("Restructure your request!");

    private final String message;

    SpellCheckResponse(String message) {
        this.message = message;
    }


}
