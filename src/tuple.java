public class tuple implements Comparable<tuple>  {
    private String letter;
    private double probability;
    private String code="";
    public tuple(String letter, double probability) {
        this.letter = letter;
        this.probability=probability;


    }

    public String getLetter() {

        return this.letter;
    }

    public double getProbability() {
        return this.probability;
    }

    public void printProb() {

        System.out.println(this.probability);
    }

    public void setCodeone() {
        this.code  = this.code.concat("1");

    }

    public void setCodezero() {

        this.code = this.code.concat("0");
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public int compareTo(tuple t) {
        if (this.probability >= t.probability) {
            return -1;
        } else {
            return 1;
        }
    }
}
