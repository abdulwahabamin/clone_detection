    /**
     * analyze and dispose the data of Cities returned from server
     */
    public static boolean handleCitiesResponse(WeatherDB weatherDB,String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities=response.split(",");
            if(allCities!=null&&allCities.length>0){
                for(String c:allCities){
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1].trim());
                    city.setProvinceId(provinceId);
                    //save the data analyzed to the table of City
                    weatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

