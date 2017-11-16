package jury;

/**
 * Created by abhisheksatpathy on 11/11/17.
 */
public class Main {
    public static void main(String[] args) {

        Jury_Pool1 k = new Jury_Pool1("/Users/abhisheksatpathy/COMP333/Ass2Part1/jury/jurorGraph0.txt");
        JuryGraph m = new JuryGraph("/Users/abhisheksatpathy/COMP333/Ass2Part1/jury/jurorGraph0.txt");
        m.printGraph();
        System.out.println(k.juryPoolSize);

        for (int i = 0; i<k.juryPoolSize; ++i){
            System.out.println(k.juryPoolList[i]);
        }
    }
}
