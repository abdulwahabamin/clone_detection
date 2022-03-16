    public boolean isToday()    {
        Cal today = new Cal(Cal.getUnixTime());
        if(today.get(today.YEAR) == this.get(this.YEAR) && today.get(today.DAY_OF_YEAR) == this.get(this.DAY_OF_YEAR))
        //if(today.getDaysInPast()==0)
            return true;
        else return false;
    }

