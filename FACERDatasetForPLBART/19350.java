    public String getOrientation() {

        if(getResources().getDisplayMetrics().widthPixels > 
           getResources().getDisplayMetrics().heightPixels) { 
            return "LANDSCAPE";
        } else {
            return "PORTRAIT";
        }     
        
    }

