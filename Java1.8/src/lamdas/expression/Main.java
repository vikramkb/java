package lamdas.expression;

@FunctionalInterface
interface BiMath<First, Second, Return> {
    Return calculate(First first, Second second);
}

public class Main {
    public static void main(String[] args) {
        //with type delcaration. Observe Integer in lamda arguments. Also return statement.
        BiMath<Integer, Integer, Integer> add = (Integer first, Integer second) -> { return first + second; };
        // auto type detection.
        // As BiMath takes Integer arguments, first and second doesn't need to specify again.
        // Single return statement doesn't need curly braces
        BiMath<Integer, Integer, Integer> sub = (first, second) -> first - second;
        BiMath<Integer, Integer, Integer> mul = (first, second) -> first * second;
        BiMath<Integer, Integer, Double> div = (first, second) -> (double)first / second;

        System.out.println("2 + 5 = " + add.calculate(2, 5));
        System.out.println("2 - 5 = " + sub.calculate(2, 5));
        System.out.println("2 * 5 = " + mul.calculate(2, 5));
        System.out.println("2 / 5 = " + div.calculate(2, 5));
    }

}
