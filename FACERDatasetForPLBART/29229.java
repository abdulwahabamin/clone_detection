    private void weekDayTransformation(){
        String wkd=wnl_spf.getString("weekDay","");
        int wkd_flag;
        for(int i=0;i<7;i++){
            if(wkd.equals(weekDayGroup[i])){
                wkd_flag=i;
                for(int j=0;j<7;j++){
                    if(wkd_flag>=7){
                        wkd_flag=0;
                    }
                    wkd=weekDayGroup[wkd_flag];
                    j++;
                    wnl_spf.edit().putString("df_weekDay_day"+j,wkd).apply();
                    j--;
                    wkd_flag++;
                }
                break;
            }
        }
    }

