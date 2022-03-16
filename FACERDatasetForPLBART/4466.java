    public boolean isCurrentMonth()    {
        Cal today = new Cal();
        if(today.get(today.MONTH) == this.get(this.MONTH))
            return true;
        else return false;
    }

