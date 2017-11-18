package jury;

/**
 * Created by abhisheksatpathy on 11/11/17.
 */
public class Main {
    public static void main(String[] args) {

        Jury_Pool1 k = new Jury_Pool1("/Users/abhisheksatpathy/COMP333/Ass2Part1/Graphs/jurorGraph6.txt");

        System.out.println("Jury Pool Size: " + k.juryPoolSize);
        System.out.print("Jury Pool List: ");
        for (int i = 0; i<k.juryPoolSize; ++i){
            System.out.print(k.juryPoolList[i] + ", ");
        }
    }
}
