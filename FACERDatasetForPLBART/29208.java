    /**
     * capture the back button, back to the cityList or provinceList according to
     * the currently Level
     */
    @Override
    public void onBackPressed() {
        if(currentLevel==LEVEL_COUNTY){
            queryCities();
        }
        else if(currentLevel==LEVEL_CITY){
            queryProvinces();
        }
        else {
            finish();
        }
    }

