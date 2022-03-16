    /**
     * analyze and dispose the data of Counties returned from server
     */
    public static boolean handleCountiesResponse(WeatherDB weatherDB,String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allCounties=response.split(",");
            if(allCounties!=null&&allCounties.length>0){
                for(String c:allCounties){
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1].trim());
                    county.setCityId(cityId);
                    //save the data analyzed to the table of County
                    weatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

