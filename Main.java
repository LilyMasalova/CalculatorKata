import java.util.Scanner;
public class Main {
    private static java.lang.Exception Exception;
    public static String calc(String input) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введи пример");
        String[] array = s.nextLine().split(" ");
        if (array.length != 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String[] Roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",

                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",

                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",

                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",

                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",

                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int a = 0;
        int b = 0;
        for (int i = 0; i < Roman.length; i++) {
            if (array[0].equals(Roman[i])) {
                a = i;
            } else if (array[2].equals(Roman[i])) {
                b = i;
            } else if (array[0].matches("[1-9]|10") && array[2].matches("[1-9]|10")) {
                a = Integer.parseInt(array[0]);
                b = Integer.parseInt(array[2]);
            }
        }

        int result;
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            switch (array[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new Exception("Некорректный ввод оператора");
            }
        } else
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");

        String result2 ="";
        for (int i = 0; i < Roman.length; i++) {
            if ( array[0].equals(Roman[i])) {
                i=result;
                result2 = Roman[i];
            } else if (array[0].matches("[1-9]|10") && array[2].matches("[1-9]|10") ) {
                result2 = "" + result;
            }
        }
        return result2;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(calc(""));
    }
}
