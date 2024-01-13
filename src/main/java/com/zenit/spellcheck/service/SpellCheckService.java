package com.zenit.spellcheck.service;


import com.zenit.spellcheck.util.ResponseJsonBody;

public interface SpellCheckService{

    ResponseJsonBody spellCheck(String word);

}

