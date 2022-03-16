    public String getTimeSlotHHMM() {
        String hour = this.get(this.HOUR_OF_DAY) < 10?"0"+this.get(this.HOUR_OF_DAY):""+this.get(this.HOUR_OF_DAY);
        int useMins=0;
        if(this.get(this.MINUTE)>29)
            useMins=30;
        String mins = useMins < 10?"0"+useMins:""+useMins;
        return hour + ":"+ mins;
    }

