    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
        wnl_spf=getSharedPreferences("WanNianLi",MODE_PRIVATE);
        listView=(ListView)findViewById(R.id.list_view);
        titleText=(TextView)findViewById(R.id.title_text);
        mBackButton=(Button)findViewById(R.id.backbutton_choosearea_activity);
        adapter=new ArrayAdapter<String>(this,R.layout.custom_list_item_1,dataList);
        listView.setAdapter(adapter);
        weatherDB=WeatherDB.getInstance(getApplicationContext());
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentLevel==LEVEL_PROVINCE){
                    selectedProvince=provinceList.get(position);
                    queryCities();
                }
                else if(currentLevel==LEVEL_CITY){
                    selectedCity=cityList.get(position);
                    queryCounties();
                }
                else if (currentLevel==LEVEL_COUNTY){
                    selected_flag=false;
                    selectedCounty=countyList.get(position);
                    String tmpStr=wnl_spf.getString("selectedCountyCount","0");
                    selectedCountyCount=Integer.parseInt(tmpStr);
                    final SharedPreferences.Editor wnlEditor=wnl_spf.edit();
                    tmpStr=selectedCounty.getCountyCode();

                    if(selectedCountyCount!=0){
                        for(int i=0;i<selectedCountyCount;i++){
                            if(tmpStr.equals(wnl_spf.getString("selectedCountyCode"+i,""))){
                                selected_flag=true;
                                Toast.makeText(ChooseCityActivity.this,"该城市已�?存在",Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                    }

                    if(!selected_flag){
                        wnlEditor.putString("selectedCountyCode"+selectedCountyCount,tmpStr);
                        tmpStr=selectedCounty.getCountyName();
                        tmpStr=tmpStr.trim();
                        wnlEditor.putString("selectedCountyName"+selectedCountyCount,tmpStr);

                        String httpUrl = "http://apis.baidu.com/heweather/weather/free";
                        String urlPara=httpUrl+"?city="+tmpStr;
                        //read the weather data from the server,then save it to local storage，
                        HttpUtil.sendHttpRequest(urlPara, true, new HttpCallbackListener() {
                            @Override
                            public void onFinish(String response) {
                                DataDisposalUtil.handleWeatherDataResponse(ChooseCityActivity.this,
                                        response,selectedCounty.getCountyCode());
                                SharedPreferences countySpf=getSharedPreferences(selectedCounty.getCountyCode(),
                                        Context.MODE_PRIVATE);
                                Date dt = new Date();
                                DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
                                countySpf.edit().putString("last_updated_at", df.format(dt)).apply();
                                selectedCountyCount++;
                                wnlEditor.putString("selectedCountyCount",""+selectedCountyCount);
                                wnlEditor.apply();
                                Intent  intent=new Intent();
                                setResult(RESULT_OK,intent);
                                finish();
                            }
                            @Override
                            public void onError(Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ChooseCityActivity.this,selectedCounty.getCountyName()
                                                +"天气数�?�更新失败，\n请检查网络连接",Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });
                    }
                }
            }
        });
        queryProvinces();//load the data of Provinces
    }

