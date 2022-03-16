    /**
     * query the specified data according to the code and type requested
     */
    private void queryFromServer(final String code,final String type){
        String address;
        if(!TextUtils.isEmpty(code)){
            address="http://www.weather.com.cn/data/list3/city"+code+".xml";
        }
        else{
            address="http://www.weather.com.cn/data/list3/city.xml";
        }
        showProgressDialog();
        HttpUtil.sendHttpRequest(address,false,new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                boolean result=false;
                if("province".equals(type)){
                    result= DataDisposalUtil.handleProvincesResponse(weatherDB,response);
                }
                else if("city".equals(type)){
                    result=DataDisposalUtil.handleCitiesResponse(weatherDB,response,selectedProvince.getId());
                }
                else if("county".equals(type)){
                    result=DataDisposalUtil.handleCountiesResponse(weatherDB,response,selectedCity.getId());
                }
                if(result){
                    /**
                     *return to the main thread to deal with the issue through the method
                     *  runOnUiThread()
                     */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        if("province".equals(type)){
                            queryProvinces();
                        }
                        else if("city".equals(type)){
                            queryCities();
                        }
                        else if("county".equals(type)){
                            queryCounties();
                        }

                    }
                });
                }
            }

            @Override
            public void onError(Exception e) {
                /**
                 *return to the main thread to deal with the issue through the method
                 *  runOnUiThread()
                 */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(ChooseCityActivity.this,"城市数�?�加载失败，请检查网络连接",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

