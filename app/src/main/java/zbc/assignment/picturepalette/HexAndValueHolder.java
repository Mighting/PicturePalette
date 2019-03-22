package zbc.assignment.picturepalette;

public class HexAndValueHolder {

    String hexcode;
    Integer value;

    public String getHexcode() {
        return hexcode;
    }

    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    public HexAndValueHolder(String hexcode, Integer value) {
        this.hexcode = hexcode;
        this.value = value;
    }
    public HexAndValueHolder() {

    }


}
