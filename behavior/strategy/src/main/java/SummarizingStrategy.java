public interface SummarizingStrategy {

    String EOL_STRING = System.lineSeparator();

    String DELIMITER = ";";

    String COMMA = ",";

    String SPACE = " ";

    String summarize(Contact[] contacts);

    String[] makeSummarizedList(Contact[] contacts);

}
