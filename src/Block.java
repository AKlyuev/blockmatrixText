import java.util.ArrayList;
import java.util.Date;

public class Block {

    private String hash;
    private String data;
    private long timeStamp; //number of milliseconds since 1/1/1970

    //Block Constructor
    public Block(String data) {
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                Long.toString(timeStamp) +
                        data
        );
        return calculatedhash;
    }


    public String getData() {
        return data;
    }

    public String toString() {
        return String.format(data);
    }

    public String getHash() {
        return hash;
    }



}
