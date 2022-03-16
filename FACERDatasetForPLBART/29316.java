    public void initFragment(MainActivity activity,int position){
        mPosition=position;
        mActivity=activity;
        wnl_spf=mActivity.getSharedPreferences("WanNianLi",Context.MODE_PRIVATE);
        mCountyName=wnl_spf.getString("selectedCountyName"+position,"");
        mCountyCode=wnl_spf.getString("selectedCountyCode"+position,"");
        mspf=mActivity.getSharedPreferences(mCountyCode, Context.MODE_PRIVATE);
    }

