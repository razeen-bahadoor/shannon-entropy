public class tuple implements Comparable<tuple>  {
    char letter;
    double probability;
    public tuple(char letter, double probability) {
        this.letter = letter;
        this.probability=probability;


    }

    public char getLetter() {

        return this.letter;
    }

    public double getProbability() {
        return this.probability;
    }

    public void printProb() {

        System.out.println(this.probability);
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
