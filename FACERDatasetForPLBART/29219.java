    private void initAdapterData(){
        //initialize RecyclerView's adapter.
        String tmp;
        mListData.clear();
        int i=Integer.parseInt(wnl_spf.getString("selectedCountyCount","0"));

        for(int j=0;j<i;j++){
            RecyclerAdapterDataModle dataModle=new RecyclerAdapterDataModle();
            tmp=wnl_spf.getString("selectedCountyName"+j,"");
            dataModle.setCityName(tmp);
            tmp=wnl_spf.getString("selectedCountyCode"+j,"");
            dataModle.setCityCode(tmp);

            SharedPreferences mSpf=getSharedPreferences(tmp,MODE_PRIVATE);
            tmp=mSpf.getString("now_cond_txt","晴间多云");
            dataModle.setWeatherText(tmp);
            dataModle.setWeatherCode(MainActivity.weatherCodeMap.get(tmp));
            tmp=mSpf.getString("df_tmp_min_day1","23")+"°~"
                    +mSpf.getString("df_tmp_max_day1","31")+"°";
            dataModle.setTmpRange(tmp);
            mListData.add(dataModle);
        }
    }

