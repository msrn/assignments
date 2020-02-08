import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static final int BLACK = 0;
    public static final int WHITE = 1;

    public static void main(String[] args) {

        ArrayList <Integer> beanCan = new ArrayList();
        ArrayList <Integer> extraPile = new ArrayList();

        fillCan(beanCan);
        fillPile(extraPile);

        int whiteBeans = printColours(beanCan);

        int lastBean = simulate(beanCan, extraPile);

        //When there is odd amount of whites then the last bean is White
        if (whiteBeans % 2 != 0 && lastBean == WHITE) {
            System.out.println("True. Odd amount of whites and last bean is WHITE");
        } else {
            System.out.println("False. Even amount of whites and last bean is BLACK");
        }



    }

    /*PRE-CONDTION: beanCan.size() >= 2
    *POST-CONDITION: beancan.size() <= 1
    * */
    public static Integer simulate(ArrayList<Integer> beanCan, ArrayList<Integer> extraPile) {
        if (beanCan.isEmpty() || extraPile.isEmpty()) {
            throw new AssertionError("Empty can");
        } else if (extraPile.size() <= beanCan.size()){
            throw new AssertionError("Extra pile smaller than bean can");
        }

        Random random = new Random();
        while (beanCan.size() >= 2) {
            assert (beanCan.size()>=2);

            Collections.shuffle(beanCan, random); //beanCan is shuffled everyime at the start of the loop
            int bean1 = beanCan.get(0);
            int bean2 = beanCan.get(1);

            int indexBean1 = beanCan.indexOf(bean1);
            int indexBean2 = beanCan.indexOf(bean2);

            if (bean1 == bean2) {

                beanCan.remove(indexBean1);
                beanCan.remove(indexBean2);
                beanCan.add(BLACK);
                extraPile.remove(0);
            }

            if (bean1 != bean2) {
                if (bean1 == BLACK) {
                    beanCan.remove(indexBean1);
                } else if (bean2 == BLACK) {
                    beanCan.remove(indexBean2);
                } else {
                    throw new AssertionError("Not possible");
                }
            }
        }

        //We here check if the process terminated correctly
        int lastBean;
        if (beanCan.size() == 1) {
            lastBean = beanCan.get(0);
            if (lastBean == BLACK) {
                System.out.println("Last bean colour BLACK");
            } else if (lastBean == WHITE)
                System.out.println("Last bean colour WHITE");
        } else {
            throw new AssertionError("Process not terminated correctly");
        }

        return lastBean;
    }

   public static void fillCan (ArrayList<Integer> list) {
        assert (list.isEmpty());
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int rand = r.nextInt(2);
            list.add(rand);
        }
    }

    private static void fillPile(ArrayList<Integer> list) {
        assert (list.isEmpty());
        for (int i = 0; i < 100; i++ ) list.add(BLACK);
    }

    private static Integer printColours(ArrayList<Integer> beanCan) {
        int blacks = 0, whites = 0;
        for (Integer i : beanCan) {
            if (i == BLACK) {
                blacks++;
            } else if (i == WHITE) {
                whites++;
            } else {
                assert (false);
            }
        }
        System.out.println("Blacks " + blacks + "\nWhites " + whites);

        return whites;
    }


}


