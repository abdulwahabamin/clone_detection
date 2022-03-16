    public int getMathDate()  {
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        String strDay = "00";
        String strMonth = "00";
        if(day<10)
            strDay = "0"+day; 
        else
            strDay = Integer.toString(day);
        if(month<10)
            strMonth = "0"+month;
        else
            strMonth = Integer.toString(month);
        String concat = year + "" + strMonth + ""+ strDay;
        int mathDate = 0;
        try {
            mathDate = Integer.parseInt(concat);
        } catch(NumberFormatException e)    {
            /// nothing needed
        }
        return mathDate;         
    }

