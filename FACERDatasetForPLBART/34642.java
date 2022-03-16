    private void initView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.city_list);
        mainLayout = (RelativeLayout) view.findViewById(R.id.fragment_city);
        refreshBar = (RelativeLayout) view.findViewById(R.id.refresh_bar);
        refresh = (ImageView) view.findViewById(R.id.refresh);
        adapter = new CityListAdapter(cities, MyApplication.getAppContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String cityName = ((CityContext) parent.getItemAtPosition(position)).getCityName();
                Logger.d(cityName);
                if (!mPresenter.isExist(cityName)) {
                    mPresenter.insertLoveCity(cityName);
                    Logger.d(cityName + "�?�入�?功");
                    Snackbar.make(mainLayout, "添加城市�?功", Snackbar.LENGTH_LONG).
                            setAction("点我撤销", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mPresenter.cancelCity(cityName);
                                    cancelRefresh();
                                }
                            }).show();
                    refreshBar.setVisibility(View.VISIBLE);
                    Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(1000);
                    animation.setRepeatCount(-1);
                    animation.setInterpolator(new LinearInterpolator());
                    refresh.startAnimation(animation);
                    mPresenter.getCityWeather(cityName);

//                    Message message = Message.obtain();
//                    message.what = UPDATE_CITY;
//                    handler.sendMessage(message) ;
                    EventBus.getDefault().post(new MessageEvent(UPDATE_CITY));

                } else {
                    Snackbar.make(mainLayout, "该城市已�?添加，你忘记了？", Snackbar.LENGTH_SHORT).show();
                }

            }
        });
    }

