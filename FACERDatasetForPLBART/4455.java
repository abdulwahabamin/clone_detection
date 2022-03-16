    public static String getDOW(int dayNum, int style) {
        String[][] dows = {
            {"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"},
            {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"},
            {"","S","M","T","W","T","F","S"}
        };
        return dows[style][dayNum];
    }

