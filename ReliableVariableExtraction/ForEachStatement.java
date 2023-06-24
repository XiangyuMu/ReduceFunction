package ReliableVariableExtraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ForEachStatement extends FatherStatement{

    private String filename;
    private int line;
    private String type;
    private String variable;
    private String iterable;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getIterable() {
        return iterable;
    }

    public void setIterable(String iterable) {
        this.iterable = iterable;
    }

    public String writeFile(){
        String s = type+"#"+line+"#"+variable+"#"+iterable;
        return s;
    }

    @Override
    public String toString() {
        return "ForEachStatement{" +
                "filename='" + filename + '\'' +
                ", line=" + line +
                ", type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", iterable='" + iterable + '\'' +
                '}';
    }

    public void readFile(String s) throws FileNotFoundException {
        String s1[] = s.split("#");
        type = s1[0];
        line = Integer.parseInt(s1[1]);
        variable = s1[2];
        iterable = s1[3];
    }


    public boolean equals(ForEachStatement forEachStatement){
        if (this.filename==forEachStatement.filename&&this.iterable==forEachStatement.iterable&&this.variable==forEachStatement.variable&&this.line==forEachStatement.line&&this.type==forEachStatement.type){
            return true;
        }else {
            return false;
        }
    }
}
