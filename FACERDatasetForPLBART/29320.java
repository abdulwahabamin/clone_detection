    private void saveDataForYestday(){
        String yestDay_date;
        String transitionDay_date=mspf.getString("transitionDay_date","");
        String today_date=mspf.getString("df_date_day1","");
        if(!transitionDay_date.equals(today_date)){
            SharedPreferences.Editor mspf_editor=mspf.edit();
            yestDay_date=transitionDay_date;
            transitionDay_date=today_date;
            mspf_editor.putString("yestDay_date",yestDay_date);
            mspf_editor.putString("transitionDay_date",transitionDay_date);

            String yestDay_weekDay=mspf.getString("transitionDay_weekDay","");
            String transitionDay_weekDay=wnl_spf.getString("df_weekDay_day1","");
            mspf_editor.putString("yestDay_weekDay",yestDay_weekDay);
            mspf_editor.putString("transitionDay_weekDay",transitionDay_weekDay);

            String yestDay_dCond_txt=mspf.getString("transitionDay_dCond_txt","");
            String transitionDay_dCond_txt=mspf.getString("df_conditionText_d_day1","");
            mspf_editor.putString("yestDay_dCond_txt",yestDay_dCond_txt);
            mspf_editor.putString("transitionDay_dCond_txt",transitionDay_dCond_txt);

            String yestDay_nCond_txt=mspf.getString("transitionDay_nCond_txt","");
            String transitionDay_nCond_txt=mspf.getString("df_conditionText_n_day1","");
            mspf_editor.putString("yestDay_nCond_txt",yestDay_nCond_txt);
            mspf_editor.putString("transitionDay_nCond_txt",transitionDay_nCond_txt);

            String yestDay_wind_dir=mspf.getString("transitionDay_wind_dir","");
            String transitionDay_wind_dir=mspf.getString("df_wind_dir_day1","");
            mspf_editor.putString("yestDay_wind_dir",yestDay_wind_dir);
            mspf_editor.putString("transitionDay_wind_dir",transitionDay_wind_dir);

            String yestDay_wind_scale=mspf.getString("transitionDay_wind_scale","");
            String transitionDay_wind_scale=mspf.getString("df_wind_sc_day1","");
            mspf_editor.putString("yestDay_wind_scale",yestDay_wind_scale);
            mspf_editor.putString("transitionDay_wind_scale",transitionDay_wind_scale);

            String yestDay_tmp_max=mspf.getString("transitionDay_tmp_max","");
            String transitionDay_tmp_max=mspf.getString("df_tmp_max_day1","");
            mspf_editor.putString("yestDay_tmp_max",yestDay_tmp_max);
            mspf_editor.putString("transitionDay_tmp_max",transitionDay_tmp_max);

            String yestDay_tmp_min=mspf.getString("transitionDay_tmp_min","");
            String transitionDay_tmp_min=mspf.getString("df_tmp_min_day1","");
            mspf_editor.putString("yestDay_tmp_min",yestDay_tmp_min);
            mspf_editor.putString("transitionDay_tmp_min",transitionDay_tmp_min);

            mspf_editor.apply();
        }

    }

