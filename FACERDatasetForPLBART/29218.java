    private void saveSelectedCounty(){
        SharedPreferences.Editor mEditor=wnl_spf.edit();
        for(int i=0;i<mListData.size();i++){
            mEditor.putString("selectedCountyName"+i,mListData.get(i).getCityName());
            mEditor.putString("selectedCountyCode"+i,mListData.get(i).getCityCode());
            mEditor.apply();
        }
        mEditor.putString("selectedCountyCount",mListData.size()+"").apply();
    }

