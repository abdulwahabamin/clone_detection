    public void setJsCalendarDate(String jsdate) {
        if(jsdate!=null && !jsdate.equals("")) {
            String[] sd = jsdate.split("-");
            this.set(this.YEAR, Sf.toInt(sd[0]));
            this.set(this.MONTH, Sf.toInt(sd[1])-1);
            this.set(this.DAY_OF_MONTH, Sf.toInt(sd[2]));
        }
    }

