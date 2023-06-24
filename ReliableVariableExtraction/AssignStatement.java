package ReliableVariableExtraction;

import java.io.FileNotFoundException;
import java.util.Objects;

public class AssignStatement extends FatherStatement{
    private String filename;
    private int line;
    private String type;
    private String Target;
    private String Value1;
    private String Value2 = "";

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public String getValue1() {
        return Value1;
    }

    public void setValue1(String value1) {
        Value1 = value1;
    }

    public String getValue2() {
        return Value2;
    }

    public void setValue2(String value2) {
        Value2 = value2;
    }

    public String writeFile(){
        String s = type+"#"+line+"#"+Target+"#"+Value1;
        if (!Value2.isEmpty()){
            s = s+"#"+Value2;
        }
        return s;
    }

    public void readFile(String s) throws FileNotFoundException {
        String s1[] = s.split("#");
        type = s1[0];
        line = Integer.parseInt(s1[1]);
        Target = s1[2];
        Value1 = s1[3];
        if (s1.length==5){
            Value2 = s1[4];
        }
    }

    @Override
    public String toString() {
        return "AssignStatement{" +
                "filename='" + filename + '\'' +
                ", line=" + line +
                ", type='" + type + '\'' +
                ", Target='" + Target + '\'' +
                ", Value1='" + Value1 + '\'' +
                ", Value2='" + Value2 + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignStatement that = (AssignStatement) o;
        return line == that.line && Objects.equals(filename, that.filename) && Objects.equals(type, that.type) && Objects.equals(Target, that.Target) && Objects.equals(Value1, that.Value1) && Objects.equals(Value2, that.Value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, line, type, Target, Value1, Value2);
    }
}
