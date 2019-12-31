import java.util.Iterator;

public class ftable implements Iterable{
    private int f_table[] = new int[256];
    private String code;
    private int Index;
    public  ftable(String code) {
            this.code = code;
        for (int i =0; i < code.length(); i++) {
            f_table[(int) code.charAt(i)] = f_table[(int) code.charAt(i)] +1;

        }

    }

    int getFrequency(char c) { return f_table[(int) c]; }
    int getCodelength() { return code.length();}
    int getIndex() {return this.Index;}
    @Override
    public Iterator iterator() {
        return new iterate();
    }

    public class iterate implements Iterator<Integer>{

            int index =0;

        @Override
        public boolean hasNext() {
            while(index < f_table.length) {
                if (f_table[index] == 0) {
                    index++;
                } else {
                    break;
                }

            }
            return !(index >= f_table.length);
        }

        @Override
        public Integer next() {

            Index = index;
            return f_table[index++];
        }
    }


}