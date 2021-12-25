package org.lessons1;


public class Math implements IMath {

    /**
     * метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – аргументы этого метода
     * @param a - param a
     * @param b - param b
     * @param c - param c
     * @param d - param d
     * @return the result
     */
    @Override
    public float mathExpressionCalc(float a, float b, float c, float d) {
        if(d != 0) {
            return a*(b+(c/d));
        }
        return 0;
    }

    /**
     * метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     * @param a - integer
     * @param b - integer
     * @return - boolean
     */
    @Override
    public boolean inRange(int a, int b) {
        int sum = a + b;
        if( 10 <= sum && sum <= 20) return true;
        return false;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     * @param a
     */
    @Override
    public boolean checkIntegerBool(int a) {
        if( a < 0) {
            return true;
        } else return false;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     * @param a
     */
    @Override
    public void checkIntegerConsole(int a) {
        if(!checkIntegerBool(a)) {
            System.out.println("Положительное");
            return;
        }
        System.out.println("Отрицательное");;
    }

    /**
     * Привет метод
     * @param name - имя
     */
    @Override
    public void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /**
     * Проверка високосного года
     * @param year - год (целое число)
     */
    public void taskEight(int year) {
        //Каждый 4-й год является високосным
        if (year % 4 != 0) {
            System.out.println("Выполнено условие 1");
            System.out.println("Простой год");
        } else {
            // кроме каждого 100-го , при этом каждый 400-й – високосный. Проверка, что год делиться на 100 без остатка и если делится на 400, то високосный
            if ((year % 100 == 0) && (year % 400 != 0)) {
                System.out.println("Простой год");
                System.out.println("Выполнено условие 2");
            }
            else {
                System.out.println("Високосный год");
                System.out.println("НЕ выполнено условие 2");
            }
        }
    }

    public static class Types {
        private byte aByte = 45;
        private short aLong = 10;
        private int anInt = 9945465;
        private float aFloat = 0.554f;
        private double aDouble = 0.06565;
        private char aChar = '<';
        private boolean aBoolean = false;

        public Types() {
        }

        public byte getaByte() {
            return aByte;
        }

        public void setaByte(byte aByte) {
            this.aByte = aByte;
        }

        public short getaLong() {
            return aLong;
        }

        public void setaLong(short aLong) {
            this.aLong = aLong;
        }

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }

        public float getaFloat() {
            return aFloat;
        }

        public void setaFloat(float aFloat) {
            this.aFloat = aFloat;
        }

        public double getaDouble() {
            return aDouble;
        }

        public void setaDouble(double aDouble) {
            this.aDouble = aDouble;
        }

        public char getaChar() {
            return aChar;
        }

        public void setaChar(char aChar) {
            this.aChar = aChar;
        }

        public boolean isaBoolean() {
            return aBoolean;
        }

        public void setaBoolean(boolean aBoolean) {
            this.aBoolean = aBoolean;
        }


        @Override
        public String toString() {
            return "Types{" +
                    "aByte=" + aByte +
                    ", aLong=" + aLong +
                    ", anInt=" + anInt +
                    ", aFloat=" + aFloat +
                    ", aDouble=" + aDouble +
                    ", aChar=" + aChar +
                    ", aBoolean=" + aBoolean +
                    '}';
        }
    }


}
