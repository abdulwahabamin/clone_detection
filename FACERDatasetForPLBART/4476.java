    public String getConcatDate()  {
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        int hour = this.get(this.HOUR_OF_DAY);
        int min = this.get(this.MINUTE);
        int sec = this.get(this.SECOND);
        return year + "" + month + ""+ day + "-" +hour+""+min+""+sec;         
    }

