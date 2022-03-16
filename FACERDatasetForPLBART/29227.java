    private void initBasicData(){
        //initialize the weekDayGroup
        get_aql_color=MyConstantValues.getAqlColorMap();
        weatherCodeMap=MyConstantValues.getWeatherCodeMap();
        backGroundRes=MyConstantValues.getBackGroundRes();
        randomNum=new Random(System.currentTimeMillis());
        weekDayGroup=new String[]{"周一","周二","周三","周四","周五","周六","周日"};
        wnl_spf=getSharedPreferences("WanNianLi",MODE_PRIVATE);
        initDate();
        int i=Integer.parseInt(wnl_spf.getString("selectedCountyCount","0"));
        if(i>0){
            ffc_flag=new String[i];
            for(int j=0;j<i;j++){
                ffc_flag[j]="true";
            }
        }else{
            ffc_flag=new String[]{"false"};
            Intent intent=new Intent(this,ChooseCityActivity.class);
            startActivityForResult(intent,2);
        }
    }

