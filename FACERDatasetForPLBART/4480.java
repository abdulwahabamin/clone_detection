    public boolean isFutureDate()    {
        //Cal today = new Cal();
        // make a random call to ensure that the Calendar time is set, if not this function will sometimes not work, mad but there you go, this caused me a massive headache
        //String tmp = this.getStringTruncDate();
        if(this.getTimeInMillis() > Cal.getUnixTime())
           return true;
        else
            return false;
    }  

