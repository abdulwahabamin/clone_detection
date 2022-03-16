    public String getDatabaseDateYYYYMMDDHH()  {
        //DecimalFormat df = new DecimalFormat( "#00" );
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        int hour = this.get(this.HOUR_OF_DAY);
        return year + "" + df.format(month) + ""+ df.format(day) + "" +df.format(hour);
    }

