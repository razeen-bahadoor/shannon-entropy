import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
            String s = "ABBCCCDDDD";
            ftable frequency;
            ArrayList<tuple> probability = new ArrayList<tuple>();
            /*if (args.length < 1) {

                System.out.println("ERROR: argument not supplied");
                System.exit(1);
            }*/

            frequency = new ftable(s);

       /*populate the probability table and sort it */
        Iterator<Integer> test= frequency.iterator();
        while (test.hasNext()) {
            int freq,index;
            freq=test.next();/*get the next freq from table*/
            index=frequency.getIndex(); /*get the index of the frequency*/
            probability.add(new tuple((char) index,freq*1.0/s.length()));

        }
        Collections.sort(probability);
       

            /*setup probability table*/


    }





}
