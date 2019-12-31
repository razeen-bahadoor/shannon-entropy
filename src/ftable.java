public class ftable {
    private int f_table[] = new int[256];
    private String code;

    public  ftable(String code) {
            this.code = code;
        for (int i =0; i < code.length(); i++) {
            f_table[(int) code.charAt(i)] = f_table[(int) code.charAt(i)] +1;

        }

    }

    int getFrequency(char c) { return f_table[(int) c]; }
    int getCodelength() { return code.length();}
}