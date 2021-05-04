package model;

public class StringResult {
    private Integer words;
    private Integer symbols;

    public StringResult() {
    }

    public StringResult(Integer words) {
        this.words = words;
    }

    public StringResult(Integer words, Integer symbols) {
        this.words = words;
        this.symbols = symbols;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Integer getSymbols() {
        return symbols;
    }

    public void setSymbols(Integer symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "StringResult{" +
                "words=" + words +
                ", symbols=" + symbols +
                '}';
    }
}
