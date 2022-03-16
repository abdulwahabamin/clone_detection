    public String getMonth(int style) {
        String[][] dows = {
            {"January","February","March","April","May","June","July","August","September","October","November","December"},
            {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"},
            {"J","F","M","A","M","J","J","A","S","O","N","D"}
        };
        String DOW = "";
        switch(this.get(this.MONTH)) {
            case 0:
                DOW = dows[style][0]; break;
            case 1:
                DOW = dows[style][1]; break;
            case 2:
                DOW = dows[style][2]; break;
            case 3:
                DOW = dows[style][3]; break;
            case 4:
                DOW = dows[style][4]; break;
            case 5:
                DOW = dows[style][5]; break;
            case 6:
                DOW = dows[style][6]; break;
            case 7:
                DOW = dows[style][7]; break;
            case 8:
                DOW = dows[style][8]; break;
            case 9:
                DOW = dows[style][9]; break;
            case 10:
                DOW = dows[style][10]; break;
            case 11:
                DOW = dows[style][11]; break;
        }
        return DOW;
    }

