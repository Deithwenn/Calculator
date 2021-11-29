public enum Roman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private int value;
    Roman(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static int getValueIfEquals(String string){
        int result = 0;
        Roman[] roman = Roman.values();
        for(int i = 0; i<roman.length; i++){
            if((roman[i].toString()).equals(string)){
                Roman romanx = Roman.valueOf(string);
                result = romanx.getValue();
                break;
            }
        }
        return result;
    }

    public static String convert(int i){
        StringBuilder sb = new StringBuilder();
        if((i>3999) || (i<1)){
            System.out.println("Ошибка, число меньше 0 или больше 3999");
        }
        while(i>=1000){
            sb.append("M");
            i -= 1000;
        }
        if(i>=900){
            sb.append("CM");
            i -= 900;
        }
        while(i>=500){
            sb.append("D");
            i -= 500;
        }
        if(i>=400){
            sb.append("CD");
            i -= 400;
        }
        while(i>=100){
            sb.append("C");
            i -= 100;
        }
        if(i>=90){
            sb.append("XC");
            i -= 90;
        }
        while(i>=50){
            sb.append("L");
            i -= 50;
        }
        if(i>=40){
            sb.append("XL");
            i -= 40;
        }
        while(i>=10){
            sb.append("X");
            i -= 10;
        }
        if(i >= 9){
            sb.append("IX");
            i -= 9;
        }
        while(i>=5){
            sb.append("V");
            i -= 5;
        }
        if(i>=4){
            sb.append("IV");
            i -= 4;
        }
        while(i >= 1){
            sb.append("I");
            i -= 1;
        }
        return sb.toString();
    }
}
