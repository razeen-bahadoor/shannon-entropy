import javax.print.DocFlavor;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * Data set class.
 * @author Razeen Bahadoor
 * @since 2020-01-01
 *
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here

            ftable frequency;
            ArrayList<tuple> probability = new ArrayList<tuple>();
            if (args.length < 1) {

                System.out.println("ERROR: argument not supplied");
                System.exit(1);
            }

            frequency = new ftable(args[0]);

       /*populate the probability table and sort it */
        Iterator<Integer> test= frequency.iterator();
        while (test.hasNext()) {
            int freq,index;
            freq=test.next();/*get the next freq from table*/
            index=frequency.getIndex(); /*get the index of the frequency*/
            probability.add(new tuple(( (char)index) +"",freq*1.0/args[0].length()));

        }
        Collections.sort(probability);


        gencodes(probability ,0, probability.size());

        StringBuilder code = new StringBuilder("");
        for(int i=0; i<args[0].length(); i++) {

            int index = findIndex(probability,args[0].charAt(i)+"");
            String t = probability.get(index).getCode();
            code.append(probability.get(index).getCode());
        }

        System.out.println(code);

    }

    /**
     * Returns the index of the string in the list.
     * @param list the arraylist.
     * @param s the character to find.
     * @return index.
     * */
    private  static int findIndex(ArrayList<tuple> list, String s) {
        int index=0;
        for(int i=0; i<list.size(); i++) {

            if( s.equals(list.get(i).getLetter())) {index=i;}
        }
        return index;
    }
    private static void gencodes(ArrayList<tuple> l , int start, int end) {

        int partition_index = partition(l);
        if (l.size() == 1){return;}
        for(int i=0; i<= partition_index; i++) {
            l.get(i).setCodezero();
        }
        for (int j=partition_index+1; j<l.size(); j++) {
            l.get(j).setCodeone();
        }
        gencodes(new ArrayList<tuple>( l.subList(0,partition_index+1)), 0 ,partition_index);
        gencodes(new ArrayList<tuple>(l.subList(partition_index+1,l.size())), partition_index+1, l.size());
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
