    /**
     * Function to get latitude
     * */
    public String getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }

        // return latitude
        return Double.toString(latitude);
    }

