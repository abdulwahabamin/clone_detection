    public void refreshData(){
        mActivity.initDate();
        String httpUrl = "http://apis.baidu.com/heweather/weather/free";
        String urlPara=httpUrl+"?city="+mCountyName;

        //read the weather data from the server,then save it to local storage，
        // and then show the weather Info.
        HttpUtil.sendHttpRequest(urlPara, true, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                DataDisposalUtil.handleWeatherDataResponse(mActivity,response,mCountyCode);
                mspf.edit().putString("update_flag","true").apply();
                //save weather data of today for use on tomorrow
                saveDataForYestday();
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showWeather();
                        if(mActivity.ffc_flag[mPosition].equals("true")){
                            Date dt = new Date();
                            DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
                            mspf.edit().putString("last_updated_at", df.format(dt)).apply();
                            Toast.makeText(mActivity,mCountyName+"天气数�?�更新�?功",Toast.LENGTH_SHORT).show();
                            mActivity.ffc_flag[mPosition]="false";
                        }

                    }
                });

            }

            @Override
            public void onError(Exception e) {
                mspf.edit().putString("update_flag","false").apply();
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String dateString=mspf.getString("df_date_day1","");
                        if(!dateString.equals("")){
                            showWeather();
                        }
                        if(mActivity.ffc_flag[mPosition].equals("true")){
                            Toast.makeText(mActivity,mCountyName+"天气数�?�更新失败，\n请检查网络连接",
                                    Toast.LENGTH_LONG).show();
                            mActivity.ffc_flag[mPosition]="false";
                        }

                    }
                });

            }
        });

    }

