public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        StringCalculator stringCalculator = new StringCalculator();

//        System.out.println(stringCalculator.add("//[%][=]\n1%2=3"));

        System.out.println(stringCalculator.add("1\n2,3"));
        System.out.println(stringCalculator.add("1,\n")); // should say string not okay ?
        System.out.println(stringCalculator.add(""));
        System.out.println(stringCalculator.add("1"));
        System.out.println(stringCalculator.add("1,2"));
        System.out.println(stringCalculator.add("1\n2,3"));
        System.out.println(stringCalculator.add("1\n\n\n2,3"));
        System.out.println(stringCalculator.add("1,2,3"));
        System.out.println(stringCalculator.add("1,2,3,4,5,6"));
        System.out.println(stringCalculator.add("1,2,3,4,5,6"));
        System.out.println(stringCalculator.add("1,2,3,4,5,,6,,"));
        System.out.println(stringCalculator.add("//[9]\n192"));
        System.out.println(stringCalculator.add("//[;]\n1;2"));
        System.out.println(stringCalculator.add("//[;]\n\n1;2"));
        System.out.println(stringCalculator.add("//[;]\n1;2;\n3"));

        // Negative numbers
        // System.out.println(stringCalculator.add("-1"));
        // System.out.println(stringCalculator.add("-1,-2"));
        // System.out.println(stringCalculator.add("-1,2"));
        // System.out.println(stringCalculator.add("1-2"));
    }

}
