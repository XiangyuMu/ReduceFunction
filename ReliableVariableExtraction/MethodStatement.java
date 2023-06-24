package ReliableVariableExtraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MethodStatement extends FatherStatement{
    private String filename;
    private int line;
    private String type;
    private String variable;
    private List<String> assignList = new ArrayList<>();

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

    public List<String> getAssignList() {
        return assignList;
    }

    public void setAssignList(List<String> assignList) {
        this.assignList = assignList;
    }

    @Override
    public String toString() {
        return "MethodStatement{" +
                "filename='" + filename + '\'' +
                ", line=" + line +
                ", type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", assignList=" + assignList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodStatement that = (MethodStatement) o;
        return line == that.line && Objects.equals(filename, that.filename) && Objects.equals(type, that.type) && Objects.equals(variable, that.variable) && Objects.equals(assignList, that.assignList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, line, type, variable, assignList);
    }
}
