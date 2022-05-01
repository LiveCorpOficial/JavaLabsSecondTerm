package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void zd1 () {
        System.out.println("*...................................*................................*");
        System.out.println(": Max Byte: " + Byte.MAX_VALUE + "\t\t\t\t\t\t: Min Byte: " + Byte.MIN_VALUE + "  \t\t\t\t :");
        System.out.println(": Max Short: " + Short.MAX_VALUE + "\t\t\t\t\t: Min Short: " + Short.MIN_VALUE + "\t\t\t\t :");
        System.out.println(": Max Integer: " + Integer.MAX_VALUE + "\t\t\t: Min Integer: " + Integer.MIN_VALUE + "\t\t :");
        System.out.println(": Max Long: " + Long.MAX_VALUE + "\t\t: Min Long: " + Long.MIN_VALUE + " :");
        System.out.println(": Max Float: " + Float.MAX_VALUE + "\t\t\t: Min Float: " + Float.MIN_VALUE + "\t\t\t :");
        System.out.println(": Max Double: " + Double.MAX_VALUE + ": Min Double: " + Double.MIN_VALUE + "\t\t\t :");
        System.out.println("*...................................*................................*");
    }

    public static void zd2 (int[] arr){
        double smArr = 1.0d;
        int count = 0;
          for (int i = 0; i < arr.length; i++){
            if(arr[i]<0){
                smArr=smArr*arr[i];
                count++;
            }
        }
        double result;
        if (count % 2 == 0)
            result = Math.pow(smArr, 1. / count);
        else
            result = -Math.pow(-smArr, 1. / count);
        System.out.println(result);
    }

    public static void zd3(int R, int r, float x, float y){
    double long1 = Math.sqrt(Math.pow(x+y,2));
        if(long1>R){
           System.out.println("Не обнаружен");
        } else if (long1<R && long1>r){
            System.out.println("Обнаружен");
        }   else {
            System.out.println("Тревога");
        }
    }

    public static void zd5(int a){
        System.out.println("Само число: " + a);
        System.out.println("Двоичная: " + Integer.toBinaryString(a));
        System.out.println("Восьмеричная: " + Integer.toOctalString(a));
        System.out.println("Шестнадцатиричная: " + Integer.toHexString(a));
        System.out.println("Четверичная: " + Integer.toString(a, 4));
    }

    public static void zd6(int StartCode, int rows, int columns) {
       int  ChangeCode = StartCode;
        System.out.print("\t  ");
        for(int i=0;i<rows;i++){
            System.out.print(Integer.toHexString(i) + "  ");
        }
        System.out.println("\n");
        for(int i = 0;i<columns;i++){
            System.out.print("");
            System.out.print(Integer.toHexString(ChangeCode) + "\t");
            System.out.print("  ");
            for(int j=0; j<rows; j++){
                int change = (StartCode + (i*16) + j);
                System.out.print((char)change);
                ChangeCode=change;
                System.out.print("  ");
            }
            System.out.println(" ");
        }
    }

    public static void zd7(String Stroka){
        char[] chArray = Stroka.toCharArray();
        short bykv = 0, malBykv = 0, bolsBykv = 0, ArabTsifr = 0, NeArab = 0, drygSimv = 0;

        for (int i = 0; i < Stroka.length(); i++) {
            char Onebykv = Stroka.charAt(i);
            short code = (short) chArray[i];
            if(Onebykv>= 'A' && Onebykv<='Z'){
                bykv++; bolsBykv++;
            }   else if (Onebykv>='a' && Onebykv<='z'){
                bykv++; malBykv++;
            }   else if(Character.isDigit(chArray[i])){
                if (code>=48 & code<=57){
                    ArabTsifr++;
                }   else {
                    NeArab++;
                }
            }   else    {
               drygSimv++;
                }
            }
        System.out.println("Количество букв: " + bykv);
        System.out.println("Количество низких букв: " + malBykv);
        System.out.println("Количество высоких букв: " + bolsBykv);
        System.out.println("Количество арабских цифр: " + ArabTsifr);
        System.out.println("Колличество не арабских цифр: " + NeArab);
        System.out.println("Количество других символов: " + drygSimv);
        System.out.println("Всего символов: " + Stroka.length());
        }

    public static void zd9() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите начальную строку: ");
        String a = reader.readLine();
        System.out.print("Введите подстроку: ");
        String b = reader.readLine();
        int count = 1;
        int start = a.indexOf(b);
        int last = a.lastIndexOf(b);
        if (start == -1)
            count = 0;
        else
            while (start < last) {
                start = a.indexOf(b, start + 1);
                ++count;
            };
        System.out.println("Подстрока встречается в заданной строке " + count + " раз(а)");
    }

    public static void zd10(String Stroka){
        char[] strChars = Stroka.toCharArray();
        for(int i = 0; i < Stroka.length(); i++) {
            for (int j = i; j < Stroka.length(); j++) {
                System.out.print(strChars[j]);
            }
            for (int k = 0; k < i; k++) {
                System.out.print(strChars[k]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //1
        System.out.println("\nЗадание 1:");
        zd1();
        console.nextLine();

        //2
        System.out.println("\nЗадание 2:");
        int[] arr = {1,-2,3,-4,5,6,7,-8,9,-10,11,12,13,14,15,16,17,18,19,20};
        zd2(arr);
        console.nextLine();

        //3
        System.out.println("\nЗадание 3");
        zd3(15,2,1.0f,5.4f);
        console.nextLine();

        //4
        System.out.println("Задание 4");
        int R = Integer.parseInt(args[0]);
        System.out.println("R = " + R);
        int r = Integer.parseInt(args[1]);
        System.out.println("r = " + r);
        float x = Integer.parseInt(args[2]);
        System.out.println("x = " + x);
        float y = Integer.parseInt(args[3]);
        System.out.println("y = " + y);
        zd3(R,r,x,y);
        console.nextLine();

        //5
        System.out.print("\nЗадание 5\nВведите число:");

        int a = console.nextInt();
        zd5(a);
        console.nextLine();
        console.nextLine();

        //6
        System.out.println("\nЗадание 6");
        int start = 0x0400;
        int FooterStart = 0x20a0;
        zd6(start, 16,16);
        System.out.print("\n\t");
        zd6(FooterStart, 16, 2);
        console.nextLine();

        //7
        System.out.println("\nЗадание 7");
        zd7("jdsafhuahf8dADFDsyf87FGsdHgGFfHsHydfhsdh<><>JH...??");
        console.nextLine();

        //9
        System.out.println("\nЗадание 9");
        zd9();
        console.nextLine();

        //10
        System.out.println("\nЗадание 10");
        System.out.println("Циклические перествановки строки abcd: ");
        zd10("asdfgh");
    }
}
