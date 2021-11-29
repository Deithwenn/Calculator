import java.util.Scanner;

public class Calculator {
    static boolean RomanInteger;
    public static void main(String[] args) {
        Scanner nscan = new Scanner(System.in);
        String operation = nscan.nextLine();
        try{
            int resultInt = calculate(operation);
            if(RomanInteger == true){
                String resultString = Roman.convert(resultInt);
                System.out.println(resultString);
            }
            else{
                System.out.println(resultInt);
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }

    }
    public static int[] integersArray(String string) throws Exception {
        int[] integers = new int[3];
        int operatorIndex = 0;

        if(string.contains("+")){
            operatorIndex = string.indexOf("+");
        }
        else if(string.contains("-")){
            operatorIndex = string.indexOf("-");
        }
        else if(string.contains("*")){
            operatorIndex = string.indexOf("*");
        }
        else if(string.contains("/")){
            operatorIndex = string.indexOf("/");
        }else{
            throw new Exception("Ошибка.");
        }

        String subFirstInt = string.substring(0, operatorIndex);
        boolean isFirstRoman = isRoman(subFirstInt);
        int firstInteger;
            if(isFirstRoman == true){
                RomanInteger = true;
                firstInteger = Roman.getValueIfEquals(subFirstInt);
            }
            else{
                firstInteger = Integer.parseInt(subFirstInt);
            }
        if(firstInteger>10) throw new Exception("Первое число больше 10");
        integers[0] = firstInteger;

        int stringSize = string.length();

        String subSecondInt = string.substring(operatorIndex+1, stringSize);
        boolean isSecondRoman = isRoman(subSecondInt);
        int secInteger;
            if(isSecondRoman == true){
                secInteger = Roman.getValueIfEquals(subSecondInt);
            }
            else{
                secInteger = Integer.parseInt(subSecondInt);
            }
        if(secInteger>10) throw new Exception("Второе число больше 10");
        integers[1] = secInteger;

        integers[2] = operatorIndex; //Индекс оператора.

        return integers;
    }
    public static int calculate(String string) throws Exception{
        int result = 0;
        int[] integers = new int[3];

        try {
            integers = integersArray(string);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        int operIndex = integers[2];
        String operator = string.substring(operIndex, operIndex+1);

        if(operator.equals("+")){
            result = integers[0] + integers[1];
        }
        else if(operator.equals("-")){
            result = integers[0] - integers[1];
        }
        else if(operator.equals("*")){
            result = integers[0] * integers[1];
        }
        else if(operator.equals("/")){
            result = integers[0] / integers[1];
        }
        else throw new Exception("Оператор неопознан");

        return result;
    }
    public static boolean isRoman(String string) throws Exception{
        Roman[] roman = Roman.values();
        boolean isRoman = false;
        for(int i = 0; i<roman.length; i++){
            if((roman[i].toString()).equals(string)){
                return isRoman = true;
            }
        }
        return isRoman;
    }
}
