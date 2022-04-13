class MainApplication {

    public static void main(String[] args) {
        /*
            Pour cet exercice, effectuer des tests unitaires n'étaient pas demandé.
            En cas réel, j'aurais pratiquer la méthode TDD (Test Driven Development) en:
                - appelant des cas dans des assertions pour tester
                - en respectant un cycle de type "test (failing) --> code writing --> test (passing) --> code refactoring"
         */

        StringCalculator stringCalculator = new StringCalculator();

        // Use cases
        System.out.println(stringCalculator.add("1\n2,3"));
        System.out.println(stringCalculator.add("1,\n"));
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
        // Negative numbers (throw exceptions)
        // System.out.println(stringCalculator.add("-1"));
        // System.out.println(stringCalculator.add("-1,-2"));
        // System.out.println(stringCalculator.add("-1,2"));
        // System.out.println(stringCalculator.add("1-2"));
    }
}
