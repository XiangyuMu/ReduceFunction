package ReliableVariableExtraction;

import java.util.ArrayList;
import java.util.List;

public class MixType {
    public List<KeyWord> keyWord = new ArrayList<>();
    public List<FatherStatement> statements = new ArrayList<>();

    public List<KeyWord> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(List<KeyWord> keyWord) {
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
        return "MixType{" +
                "keyWord=" + keyWord +
                ", statements=" + statements +
                '}';
    }
}
