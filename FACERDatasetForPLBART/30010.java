    /**
     * Function to get longitude
     * */
    public String getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }

        // return longitude
        return Double.toString(longitude);
    }

