    public int getDaysInPast()  {
        int daysInPast = 0;
        //System.out.println("start days in past:"+this.isPastDate());
        //boolean ispastdate = this.isPastDate();
        if(this.isPastDate()) {
            //System.out.println("is past date");
            Cal today = new Cal();
            int todayDay = today.get(today.DAY_OF_YEAR);
            int thisDay = this.get(this.DAY_OF_YEAR);
            if(today.get(today.YEAR)>this.get(this.YEAR)) {
                int tmp = 365-thisDay;
                daysInPast = tmp + todayDay;
            } else {
                daysInPast = todayDay - thisDay;
            }
        }
        //System.out.println("days in past for: "+this.getStringTruncDate()+" is "+daysInPast);
        return daysInPast;
    }

