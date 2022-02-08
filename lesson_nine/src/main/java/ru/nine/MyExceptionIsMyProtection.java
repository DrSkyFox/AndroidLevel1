package ru.nine;


public class MyExceptionIsMyProtection {


    private String[][] strMat;
    private Integer sizeQuad;
    private WrongSection wrongSection;

    public MyExceptionIsMyProtection(Integer sizeQuad) {
        this.sizeQuad = sizeQuad;
    }

    public String[][] getStrMat() {
        return strMat;
    }

    public void setStrMat(String[][] strMat) throws MyArraySizeException {
        System.out.println(strMat.length);
        System.out.println(strMat[0].length);
        if((strMat.length > sizeQuad) || (strMat[0].length > sizeQuad)) {
            throw new MyArraySizeException("Size must less -" + sizeQuad );
        }
        this.strMat = strMat;
    }


    public Integer getSumOfAllElements() throws MyArrayDataException {
        int i,j = 0;
        Integer sum = 0;
        wrongSection = new WrongSection(0,0);
        try {
            for (i = 0; i < strMat.length; i++) {
                for (j = 0; j < strMat[0].length; j++) {
                    wrongSection.setI(i);
                    wrongSection.setJ(j);
                    sum += Integer.valueOf(strMat[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка в элементе - " + wrongSection);
        }
        return sum;
    }

    private class WrongSection {
        private int i;
        private int j;

        public WrongSection(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        @Override
        public String toString() {
            return "WrongSection{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }



}

