package com.zenit.spellcheck;

import com.zenit.spellcheck.enums.SpellCheckResponse;
import com.zenit.spellcheck.service.SpellCheckService;
import com.zenit.spellcheck.util.ResponseJsonBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpellCheckControllerTests {

	@Autowired
	private SpellCheckService spellCheckService;

	@Test
	void testSpellCheckWithValidInput() {

		String key = "2001";
		String ip = "0:0:0:0:0:0:0:1";
		String language = "EN";
		String word = "dije";

		ResponseJsonBody result = spellCheckService.spellCheck(key, ip, language, word);

		assertEquals(HttpStatus.OK, result.getStatus());
		assertEquals(SpellCheckResponse.SUCCESSFULLY_RETRIEVED.getMessage(), result.getMessage());
		assertEquals(Arrays.asList("dije", "dije", "di"), result.getData());
		assertEquals(new ArrayList<>(), result.getErrors());

	}

	@Test
	void testSpellCheckWithInvalidInput() {

		String key = "";
		String ip = "0:0:0:0:0:0:0:1";
		String language = "EN";
		String word = "dije";

		ResponseJsonBody result = spellCheckService.spellCheck(key, ip, language, word);

		assertEquals(HttpStatus.BAD_REQUEST, result.getStatus());
		assertEquals(SpellCheckResponse.RESTRUCTURE_YOU_REQUEST.getMessage(), result.getMessage());
		assertEquals(new ArrayList<>(), result.getData());
		assertEquals(Collections.singletonList(SpellCheckResponse.WRONG_KEY.getMessage()), result.getErrors());

	}

	@Test
	void testCheckValidations() {

		String key = "";
		String ip = "0:0:0:0:0:0:0:1";
		String language = "EN";
		String word = "dije";

		ResponseJsonBody result = spellCheckService.spellCheck(key, ip, language, word);

		assertEquals(HttpStatus.BAD_REQUEST, result.getStatus());
		assertEquals(SpellCheckResponse.RESTRUCTURE_YOU_REQUEST.getMessage(), result.getMessage());
		assertEquals(new ArrayList<>(), result.getData());
		assertEquals(Collections.singletonList(SpellCheckResponse.WRONG_KEY.getMessage()), result.getErrors());

	}

}
