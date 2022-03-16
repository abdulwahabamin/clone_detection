    public static String getMonth(int monthNum, int style) {
        String[][] dows = {
            {"","January","February","March","April","May","June","July","August","September","October","November","December"},
            {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"},
            {"","J","F","M","A","M","J","J","A","S","O","N","D"}
        };
        return dows[style][monthNum];
    }

