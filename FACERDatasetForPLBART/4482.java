    public boolean isExpiredDate()    {
        Cal today = new Cal();
        if(this.get(this.YEAR)> today.get(today.YEAR))
            return false;
        if(this.get(this.MONTH)> today.get(today.MONTH))
            return false;
        if(this.get(this.DAY_OF_MONTH)>today.get(today.DAY_OF_MONTH))
            return false;
        if(this.get(this.HOUR)> today.get(today.HOUR))
            return false;
        if(this.get(this.MINUTE)> today.get(today.MINUTE))
            return false;
        if(this.get(this.SECOND)> today.get(today.SECOND))
            return false;
        return true;
    }

