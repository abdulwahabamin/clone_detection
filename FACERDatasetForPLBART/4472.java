    public String getDatabaseTruncDate()  {
        //DecimalFormat df = new DecimalFormat( "#00" );
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        return year + "-" + df.format(month) + "-"+ df.format(day);      
    }

