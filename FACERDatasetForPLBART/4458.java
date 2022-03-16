    public String getDOW(int style) {
        String[][] dows = {
            {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"},
            {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"},
            {"S","M","T","W","T","F","S"}
        };
        String DOW = "";
        switch(this.get(this.DAY_OF_WEEK)) {
            case 1:
                DOW = dows[style][0]; break;
            case 2:
                DOW = dows[style][1]; break;
            case 3:
                DOW = dows[style][2]; break;
            case 4:
                DOW = dows[style][3]; break;
            case 5:
                DOW = dows[style][4]; break;
            case 6:
                DOW = dows[style][5]; break;
            case 7:
                DOW = dows[style][6]; break;
        }
        return DOW;
    }

