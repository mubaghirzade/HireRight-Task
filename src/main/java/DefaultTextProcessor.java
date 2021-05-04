import model.StringResult;

import java.util.Set;

public class DefaultTextProcessor implements TextProcessor{

    private Set<String> stopWords;
    private Boolean countSymbols = false;
    private Boolean onlyCapital = false;

    public DefaultTextProcessor(){

    }

    public DefaultTextProcessor(Set<String> stopWords){
        this.stopWords = stopWords;

    }

    public DefaultTextProcessor(Set<String> stopWords, Boolean countSymbols, Boolean onlyCapital) {
        this.stopWords = stopWords;
        this.countSymbols = countSymbols;
        this.onlyCapital = onlyCapital;
    }

    public void setStopWords(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public void setCountSymbols(Boolean countSymbols) {
        this.countSymbols = countSymbols;
    }

    public void setOnlyCapital(Boolean onlyCapital) {
        this.onlyCapital = onlyCapital;
    }

    @Override
    public StringResult process(String text) {

        Integer words = 0;
        Integer symbols = 0;

        String[] wordList = text.split("\\s");

        for (String word : wordList){
            if (isOk(word)){
                words++;

                if (countSymbols){
                    symbols += word.length();
                }
            }
        }

        return new StringResult(words, symbols);
    }

    private Boolean isOk(String word){
        if (stopWords != null && stopWords.contains(word)){
            return false;
        }

        if (onlyCapital && !Character.isUpperCase(word.charAt(0))){
            return false;
        }

        return true;
    }
}
