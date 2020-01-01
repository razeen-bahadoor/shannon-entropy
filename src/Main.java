import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
            String s = "HelloWorld";
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
        for (tuple t: probability) {
            System.out.println(t.getProbability());
        }
        int p = partition(probability);
        System.out.println(p);
            /*setup probability table*/


    }



    private static int partition(ArrayList<tuple> list) {
        int parition_index = 0;
        double min_diff=1000;
        for (int index =0; index < list.size(); index++) {

            if ((sum(0,index,list) - sum(index+1, list.size() -2,list) ) <= min_diff) {

                parition_index = index;
                min_diff = sum(0,index,list) - sum(index+1, list.size() -1,list);
                min_diff = Math.abs(min_diff);
            }

        }

        return parition_index;
    }

    private static  double sum(int start, int end, ArrayList<tuple> list) {


            double s = 0;
            for(int i = start; i<=end; i++) {

                s = s + list.get(i).getProbability();
            }
            return s;

    }


}
