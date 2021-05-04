import model.StringResult;

import java.io.File;
import java.util.Set;

public class Application {

    static Set<String> files = Set.of();
    static TextProcessor processor;


    public static void main(String[] args) throws Exception {

        processor = new DefaultTextProcessor();

        for(String arg : args){
            switch (arg.substring(0, 2)){
                case "-F":
                    files = Set.of(arg.substring(3).split(","));
                    break;
                case "-S":
                    processor.setStopWords(Set.of(arg.substring(3).split(",")));
                    break;
                case "-L":
                    processor.setOnlyCapital(true);
                    break;
                case "-C":
                    processor.setCountSymbols(true);
                    break;
                default:
                    throw new Exception("Unknown argument: " + arg);
            }
        }

        for (String file : files){
            StringResult result = processor.process(TxtReader.readFile(new File(file)));
            System.out.println(result.toString());
        }

    }
}
