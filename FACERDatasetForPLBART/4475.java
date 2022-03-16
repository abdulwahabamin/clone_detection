    public String getTruncConcatDate()  {
        int day = this.get(this.DAY_OF_MONTH);
        int month = this.getRealMonth();
        int year = this.get(this.YEAR);
        return year + "" + month + ""+ day;         
    }

