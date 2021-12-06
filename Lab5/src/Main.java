import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Grammar grammar = new Grammar();
        String file = "src\\g4.txt";
        grammar.readFromFile(file);
        grammar.printNonTerminals();
        grammar.printTerminals();
        grammar.printProductions();
        grammar.printProductionsForAGivenNonTerminal("stmtlist");
        System.out.println(grammar.isCFG());
        LR0 lr0 = new LR0(grammar);

        List<Item> items = new ArrayList<>();
        for(String s:grammar.getP().keySet())
        {
            for(List<String> list:grammar.getP().get(s))
                items.add(new Item(s,list));

        }
        //System.out.println(productions);
        //lr0.closure(productions);
        //System.out.println(lr0.closure(productions));
        //System.out.println(lr0.goTo(productions, "b"));
//        List<String> rightHandSide = new ArrayList<>();
//        rightHandSide.add("S");
//        List<Production> productionsS0 = new ArrayList<>();
//        productionsS0.add(new Production("S'", rightHandSide));
//        List<Production> s0 = lr0.closure(productionsS0);
//        System.out.println(s0);
//        //System.out.println(lr0.goTo(s0,"a"));
//        List<Production> s2=lr0.goTo(s0,"a");
//        System.out.println();
//        System.out.println(s2);
//        System.out.println(lr0.goTo(s2,"A"));
        //System.out.println(lr0.canonicalCollection());
        List<List<Item>> states=lr0.canonicalCollection();
        System.out.println(lr0.stateToString(states));
        System.out.println(lr0.generateLR0Table(states));

    }
}
