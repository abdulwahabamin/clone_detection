    public void setJsCalendarDate(String jsdate,String jstime) {
        if(jsdate!=null && jstime!=null) {
            String[] sd = jsdate.split("-");
            this.set(this.YEAR, Sf.toInt(sd[0]));
            this.set(this.MONTH, Sf.toInt(sd[1])-1);
            this.set(this.DAY_OF_MONTH, Sf.toInt(sd[2]));
            String[] st = jstime.split(":");
            this.set(this.HOUR_OF_DAY, Sf.toInt(st[0]));
            this.set(this.MINUTE, Sf.toInt(st[1]));
        }
    }

