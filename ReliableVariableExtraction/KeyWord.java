package ReliableVariableExtraction;

public class KeyWord {

    private String name;
    private String type;

    public KeyWord(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "KeyWord{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }



    public boolean isEuqal(KeyWord keyWord){
        if (this.name == keyWord.getName()&&this.type == keyWord.getType()){
            return true;
        }else {
            return false;
        }
    }
}
