    public String getStringDate()  {
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        int hour = this.get(this.HOUR_OF_DAY);
        int min = this.get(this.MINUTE);
        int sec = this.get(this.SECOND);
        return df.format(day) + "/" + df.format(month) + "/"+ year + " " +df.format(hour)+":"+df.format(min)+":"+df.format(sec);         
    }

