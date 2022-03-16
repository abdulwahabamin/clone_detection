    public Cal clone()  {
        Cal cloned = new Cal(this.get(this.YEAR),this.get(this.MONTH),this.get(this.DAY_OF_MONTH)
                                ,this.get(this.HOUR_OF_DAY), this.get(this.MINUTE), this.get(this.SECOND));
        //int fdow = this.getFirstDayOfWeek();
        //cloned.setFirstDayOfWeek(fdow);
        return cloned;
    }

