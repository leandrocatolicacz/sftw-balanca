package classes;

public class Produto {
    private int code;
    private String description;
    private String type;
    private double value;

    public Produto() {
    }

    public Produto(int code, String description, String type, double value) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
