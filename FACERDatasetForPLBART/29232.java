    /**
     * analyze and dispose the data of Provinces returned from sever
     */
    public  static boolean handleProvincesResponse(WeatherDB weatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces=response.split(",");
            if(allProvinces!=null&&allProvinces.length>0){
                for(String p:allProvinces){
                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1].trim());
                    //save the data analyzed to the table of Province
                    weatherDB.saveProvince(province);
                }
                return true;
            }

        }
        return false;
    }

