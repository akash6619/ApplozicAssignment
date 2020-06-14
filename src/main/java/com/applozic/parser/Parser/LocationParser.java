package com.applozic.parser.Parser;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class LocationParser {
    InputStream inputStreamTokenizer;
    TokenizerModel tokenModel;
    InputStream inputStreamNameFinder;
    TokenNameFinderModel model;

    public LocationParser() throws IOException {
        inputStreamTokenizer = this.getClass().getClassLoader().getResourceAsStream("en-token.bin");
        tokenModel = new TokenizerModel(inputStreamTokenizer);
        inputStreamNameFinder = this.getClass().getClassLoader().getResourceAsStream("en-ner-location.bin");
        model = new TokenNameFinderModel(inputStreamNameFinder);
    }

    public void parseTextForLocation(String text){
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        String[] tokens=tokenizer.tokenize(text);
        NameFinderME nameFinder = new NameFinderME(model);
        Span nameSpans[] = nameFinder.find(tokens);
        if(nameSpans.length==0) {
            System.out.println("Can't detect location info.");
        }else{
            System.out.println("Location Info:");
            Arrays.stream(nameSpans).forEach(s -> System.out.println(tokens[s.getStart()]));
        }
    }
}
