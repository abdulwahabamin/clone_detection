    public String getNextPaypalDate(int plusMonths)  {
        this.set(this.MONTH,this.get(this.MONTH)+plusMonths);
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        String smonth = new Integer(month).toString();
        String sday = new Integer(day).toString();
        if(day<10)
            sday = "0"+sday;
        if(month<10)
            smonth="0"+smonth;
        
        return smonth + sday +""+year;
    }

