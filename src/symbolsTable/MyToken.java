package symbolsTable;

import org.antlr.runtime.CommonToken;

public class MyToken extends CommonToken {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String srcName;

    public MyToken(int type, String text) {
        super(type, text);
    }

    @Override
    public String toString() {
        String t = super.toString();
        return srcName + ":" + t;
    }
}