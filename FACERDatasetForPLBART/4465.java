    public boolean isCurrentWeek()    {
        Cal today = new Cal();
        if(today.get(today.WEEK_OF_YEAR) == this.get(this.WEEK_OF_YEAR))
            return true;
        else return false;
    }

