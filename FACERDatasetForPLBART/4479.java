    public String getStringTruncDate()  {
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        String strDay = "00";
        String strMonth = "00";

        return  df.format(day)+ " / " + df.format(month) + " / "+ year;
                
    }

