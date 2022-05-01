package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static void zd1() {
        System.out.printf("%-17s %-22s %-20s", "x", "sin","exp");
        System.out.print("\n");
        for (double x = Math.PI / 15; x < Math.PI; x = x + Math.PI / 15) {
            System.out.printf("%1$10s%2$2.5f%3$15s%4$2.7f", "x\t\t", Math.sin(x), "", Math.exp(x) / (x * Math.log(x)), "\n");
            System.out.println();
        } // placeholder
    }

    static void zd2() {
        int[][] matrix = {
                {1, 2, -3},
                {4, -5},
                {-6, -2, 9, -7}};
        int num = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d", anInt);
                 if (anInt < 0)
                    if (anInt > num) num = anInt;
            }
            System.out.println();
        }
        System.out.println("Наибольший отрицательный элемент массива: " + num);
    }

    static void zd3(){
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите число: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("error");
                    break;
                }
                else matrix[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        System.out.println("Неотсортированный:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
        System.out.println("Отсортированный:");
        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }

    static void zd4(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Первая окружность\n\tВведите x1: ");
        double x1=scanner.nextDouble();
        System.out.print("\tВведите y1: ");
        double y1=scanner.nextDouble();
        System.out.print("\tВведите r1: ");
        double r1=scanner.nextDouble();
        System.out.print("Вторая окружность\n\tВведите x2: ");
        double x2=scanner.nextDouble();
        System.out.print("\tВведите y2: ");
        double y2=scanner.nextDouble();
        System.out.print("\tВведите r2: ");
        double r2=scanner.nextDouble();

        double line = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        if (line < r2 + r1) System.out.println("Пересекаются в двух точках");
        else if (line == r2 + r1) System.out.println("Пересекаются в одной точке, внешнее касание");
        else if (line == Math.abs(r2 - r1)) System.out.println("Пересекаются в одной точке, внутреннее касание");
        else if (x1 == x2 && y1 == y2 && r1 == r2) System.out.println("Окружности совпадают");
        else if (x1 == x2 && y1 == y2 && r1 < r2 || r2 < r1) System.out.println("Окружности вложенные");
        else System.out.println("Не пересекаются");
    }

    enum Par {
        Пересекаюся,
        Не_пересекаются,
        Совпадают,
        Вложенные,
        Пересекаются_В_Одной_Точке_Внешнее_Касание,
        Пересекаются_В_Одной_Точке_Внутреннее_Касание
    }

    static Par zd5(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Первая окружность\n\tВведите x1: ");
        double x1=scanner.nextDouble();
        System.out.print("\tВведите y1: ");
        double y1=scanner.nextDouble();
        System.out.print("\tВведите r1: ");
        double r1=scanner.nextDouble();
        System.out.print("Вторая окружность\n\tВведите x2: ");
        double x2=scanner.nextDouble();
        System.out.print("\tВведите y2: ");
        double y2=scanner.nextDouble();
        System.out.print("\tВведите r2: ");
        double r2=scanner.nextDouble();

        double rasstoinie = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        if (rasstoinie > Math.abs(r2 - r1) && rasstoinie < r2 + r1) return Par.Пересекаюся;
        else if (rasstoinie == r2 + r1) return Par.Пересекаются_В_Одной_Точке_Внешнее_Касание;
        else if (rasstoinie == Math.abs(r2 - r1)) return Par.Пересекаются_В_Одной_Точке_Внутреннее_Касание;
        if (x1 == x2 && y1 == y2 && r1 == r2) return Par.Совпадают;
        else if (x1 == x2 && y1 == y2 && r1 < r2 || r2 < r1)return Par.Вложенные;
        else return Par.Не_пересекаются;
    }

    public static double zd6(double a, double b, int n) {
        double result = 0;
        double h = (b - a) / n;
        double x = a;
        double[][] matrix = new double[n][2];
        double f = Math.exp(x) - (x * x * x);
        matrix[0][0] = x;
        matrix[0][1] = f;
        for (int i = 1; i < n-1; i++) {
            x += h;
            f = Math.exp(x) - (x * x * x);
            matrix[i][0] = x;
            matrix[i][1] = f;
            System.out.println("f(" + matrix[i][0] + ")\t  =\t\t" + matrix[i][1]);
            result = result + matrix[i][1] * h;
        }
        return result;
    }

    static void zd7(){
        Scanner console = new Scanner(System.in);

        int num, sist;
        String New_sist = "";

        System.out.print("Введите число которое нужно преобразовать: ");
        num = console.nextInt();
        System.out.print("Введите основание системы счисления: ");
        sist = console.nextInt();

        while (num != 0) {
            New_sist += num % sist;
            num = num / sist;
        }
        New_sist += num;
        New_sist = new StringBuilder(New_sist).reverse().toString();
        System.out.println("Преобразованное число: "+ New_sist);
    }
    static void zd7_spectate(){
        Scanner console = new Scanner(System.in);
        System.out.println("Введите преобразуемое десятичное число ");
        int num = console.nextInt();
        System.out.println("Введите основание системы счисления ");
        int sist = console.nextInt();
        System.out.println ("Ваше число: " + Integer.toString(num,sist));
    }

    static void zd8(int n,int x){

        Scanner sc = new Scanner(System.in);
        int[] a = new int[n+1];

        for (int i = 0; i < a.length; i++) {
            System.out.print("Введите " + (i+1) + " число: ");
                a[i] = sc.nextInt();
        }
        for (int i = n-2, P = a[n] * x + a[n - 1]; i!=0 ; i--,P = P * x + a[i]) {
            System.out.println(P);
        }
    }

    static void zd9() {
        Scanner sc = new Scanner(System.in);
        String PhoneNum = "+7-904-378-16-61";
        System.out.println(PhoneNum.matches("((\\+7)|8)(-|\\s|)((\\d{3})|(\\(\\d{3}\\)))(\\s|-|)\\d{3}((\\s|-|)\\d{2}){2}"));

        sc.nextLine();

        String text = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
        Pattern pattern = Pattern.compile("((2|3))(\\s\\d{2}|\\-\\d{2}|\\d{2})(\\s\\d{2}|\\-\\d{2})(\\s\\d{2}|\\-\\d{2})");
        Matcher mat = pattern.matcher(text);
        while (mat.find()) {
            System.out.println(text.substring(mat.start(), mat.end()));
        }
    }

    static void zd10(){
        Pattern regular_mun_tel = Pattern.compile("((2|3))(\\s\\d{2}|\\-\\d{2}|\\d{2})(\\s\\d{2}|\\-\\d{2})(\\s\\d{2}|\\-\\d{2})");
        String text = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
        Matcher mat = regular_mun_tel.matcher(text);
        System.out.println("Исходный текст: \n" + text);
        System.out.println("\nИзвлекаем номера из строки: ");
        while (mat.find()) {
            System.out.println(text.substring(mat.start(), mat.end()));
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        System.out.println("Задание 1\n");
        zd1();
        sc.nextLine();

        System.out.println("Задание 2\n");
        zd2();
        sc.nextLine();

        System.out.println("Задание 3\n");
        zd3();
        sc.nextLine();

        System.out.println("Задание 4\n");
        zd4();
        sc.nextLine();

        System.out.println("Задание 5\n");
        System.out.println(zd5());
        sc.nextLine();

        System.out.println("Задание 6\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во интервалов разбиения: ");
        System.out.println("Результат: "+ zd6(2 ,6, scanner.nextInt()));
        sc.nextLine();

        System.out.println("Задание 7\n");
        zd7();
        sc.nextLine();

        System.out.println("Проверка: ");
        zd7_spectate();
        sc.nextLine();

        System.out.println("Задание 8\n");
        zd8(4,3);
        sc.nextLine();
*/
        System.out.println("Задание 9\n");
        zd9();
        sc.nextLine();

        System.out.println("Задание 10\n");
        zd10();
    }
}




/* Pattern regular = Pattern.compile("((\\+7|8)(\\s\\d{3}|\\-\\d{3}|\\d{3}|\\(\\d{3}|\\s\\(\\d{3})(\\)\\s\\d{3}|\\d{3}|\\s\\d{3}|\\-\\d{3}|\\)\\d{3}|\\)\\-\\d{3})(\\s\\d{2}|\\-\\d{2}|\\d{2})(\\d{2}|\\s\\d{2}|\\-\\d{2}))");
        String stack = "+79043781661" +
                "+7 904 378 1661" +
                "+7 904 378 16 61" +
                "0 7144 2 99" +         // не пройдёт
                "+7-904-378-16-61" +
                "+7(904)3781661" +
                "-7 12" +               //не пройдёт
                "+7(904) 378-16 61" +
                "89043781661" +
                "8950-862(18-38)" +     //не пройдёт
                "8 904 378-16-61";
        Matcher m = regular.matcher(stack);
        System.out.println("Номера, прошедшие регулярку: ");
        while (m.find()) {
            int begin = m.start();
            int end = m.end();
            System.out.println(stack.substring(begin, end));


            Pattern regular_mun_tel = Pattern.compile("((2|3))(\\s\\d{2}|\\-\\d{2}|\\d{2})(\\s\\d{2}|\\-\\d{2})(\\s\\d{2}|\\-\\d{2})");
        String text = "220-30-40 8904-378-16-61";
        Matcher n = regular_mun_tel.matcher(text);
        System.out.println("\nМуниципальные номера, прошедшие регулярку: ");
        while (n.find()) {
            int begin = n.start();
            int end = n.end();
            System.out.println(text.substring(begin, end));
        }
        }*/
/*static void zd7(){
        Scanner console = new Scanner(System.in);

        int num, sist;
        int i = 1;
        int[] oct_num = new int[10];

        System.out.print("Введите число которое нужно преобразовать: ");
        num = console.nextInt();
        System.out.print("Введите основание системы счисления: ");
        sist = console.nextInt();
        while (num != 0) {
            oct_num[i++] = num % sist;
            num = num / sist;
        }
        System.out.print("Преобразованное число ");
        for(int j = i-1; j > 0; j--) {
            System.out.print(oct_num[j]);
        }
        System.out.println(" в " + sist + " системе счисления");
    }*/