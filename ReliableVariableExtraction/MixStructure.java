package ReliableVariableExtraction;

import java.util.ArrayList;
import java.util.List;

public class MixStructure {
    public List<String> keyWord = new ArrayList<>();
    public List<FatherStatement> statements = new ArrayList<>();

    public List<String> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(List<String> keyWord) {
        this.keyWord = keyWord;
    }

    public List<FatherStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<FatherStatement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "MixStructure{" +
                "keyWord=" + keyWord +
                ", statements=" + statements +
                '}';
    }
}
