package main;

import java.util.Scanner;

public class Main {

    // logic handler methods

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int operationNum = 0;
            boolean stop;
            do {
                operationNum = calculator(scanner);
                stop = operationNum == 5;
                int result = getResult(scanner, operationNum);
                printResult(result);
            } while (!stop);
        }
    }

    public static int calculator(Scanner scanner) {
        int operationNum;
        boolean bad;
        do {
            operationNum = readOperationNum(scanner);
            bad = checkOperationNum(operationNum);
            if (bad) {
                printBadOperationNumMessage();
            }
        } while (bad);
        return operationNum;
    }

    public static int getResult(Scanner scanner, int operationNum) {
        int result = 0;
        switch (operationNum) {
            case 1:
                result = additionOp(scanner);
                break;
            case 2:
                result = subtractionOp(scanner);
                break;
            case 3:
                result = multiplicationOp(scanner);
                break;
            case 4:
                result = divisionOp(scanner);
                break;
            case 5:
//                exitOp();
                break;
            default:
                defaultOp();
                break;
        }
        return result;
    }

    public static boolean checkOperationNum(int operationNum) {
        boolean bad;
        bad = operationNum < 1 || 5 < operationNum;
        return bad;
    }

    // readers (user input handler methods)

    public static int readOperationNum(Scanner scanner) {
        int operationNum = 0;
        System.out.print("Az alábbi műveletek közül választhatsz: " +
                "\n\t1.összeadás\n\t2. kivonás\n\t3. szorzás\n\t4. osztás\n\t5. kilép\nKérem a művelet számát: ");
        operationNum = scanner.nextInt();
        return operationNum;
    }

    public static int[] readNumbers(Scanner scanner) {
        System.out.print("Kérem az első számot: ");
        int firstNum = scanner.nextInt();
        System.out.print("Kérem a második számot: ");
        int secondNum = scanner.nextInt();
        return new int[]{firstNum, secondNum};
    }

    public static int readSecondNumber(Scanner scanner) {
        int secondNum = 0;
        do {
            System.out.print("Nullával nem lehet osztani, adj meg egy megfelelő számot: ");
            secondNum = scanner.nextInt();
        } while (secondNum == 0);
        return secondNum;
    }

    // operationOps

    public static int additionOp(Scanner scanner) {
        System.out.println("Az összeadás műveletet választottad.");
        int[] numbers = readNumbers(scanner);
        return addition(numbers);
    }

    public static int subtractionOp(Scanner scanner) {
        System.out.println("A kivonás műveletet választottad.");
        int[] numbers = readNumbers(scanner);
        return subtraction(numbers);
    }

    public static int divisionOp(Scanner scanner) {
        System.out.println("Az osztás műveletet választottad.");
        int[] numbers = readNumbers(scanner);
        if (numbers[1] == 0) {
            numbers[1] = readSecondNumber(scanner);
        }
        return division(numbers);
    }

    public static int multiplicationOp(Scanner scanner) {
        System.out.println("A szorzás műveletet választottad.");
        int[] numbers = readNumbers(scanner);
        return multiplication(numbers);
    }

    public static void exitOp() {
        System.out.println("Kilépést választottad.");
        System.exit(0);
    }

    public static void defaultOp() {
        System.out.println("Nem létező opció.");
    }

    // operations

    public static int addition(int[] numbers) {
        return numbers[0] + numbers[1];
    }

    public static int subtraction(int[] numbers) {
        return numbers[0] - numbers[1];
    }

    public static int multiplication(int[] numbers) {
        return numbers[0] * numbers[1];
    }

    public static int division(int[] numbers) {
        return numbers[0] / numbers[1];
    }

    // print outputs

    public static void printBadOperationNumMessage() {
        System.out.print("Rossz számot választottál! ");
    }

    public static void printResult(int result) {
        System.out.println("Az eredmény: " + result);
        System.out.println();
    }

}
 