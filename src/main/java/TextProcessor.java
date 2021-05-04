import model.StringResult;

import java.util.Set;

public interface TextProcessor {

    StringResult process(String text);

    public void setStopWords(Set<String> stopWords);

    public void setCountSymbols(Boolean countSymbols);

    public void setOnlyCapital(Boolean onlyCapital);
}
