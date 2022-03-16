    /**
     * 更新与该refreshableView对应的mCountyCode,SharedPreference
     */
    public void setData(String countyCode){
        mCountyCode=countyCode;
        mSpf=null;
        mSpf=getContext().getSharedPreferences(mCountyCode,Context.MODE_PRIVATE);
    }

