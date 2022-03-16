    public static String friendlyReadDate(Cal din) {
        String frd="";
        if(din==null) {
            frd="?";
        } else {
            if(din.isToday()) {
                //Cal now=new Cal();
                long mili = Cal.getUnixTime()-din.getTimeInMillis();
                mili=(mili/1000)/60;
                if(mili>59) {
                    mili=(mili/60);
                    if(mili<2)
                        frd=mili+"h";
                    else
                        frd=mili+"h";
                } else {
                    if(mili<1)
                        frd="secs";
                    else if(mili<2)
                        frd=mili+"m";
                    else
                        frd=mili+"m";
                }

            } else {
                frd=din.getDaysInPast()+"d";
            }
        }
        return frd;
    }

