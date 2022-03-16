    private void getNow(String location, final boolean nowCity) {
        HeWeather.getSearch(this, location, "cn,overseas", 3, Lang.CHINESE_SIMPLIFIED, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onSuccess(Search search) {
                Basic basic = search.getBasic().get(0);
                String cid = basic.getCid();
                String location = basic.getLocation();
                if (nowCity) {
                    ContentUtil.NOW_CITY_ID = cid;
                    ContentUtil.NOW_CITY_NAME = location;
                    if (cityIds != null && cityIds.size() > 0) {
                        cityIds.add(0, cid);
                        cityIds.remove(1);
                    }
                }
                HeWeather.getWeatherNow(MainActivity.this, cid, new HeWeather.OnResultWeatherNowBeanListener() {
                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onSuccess(Now list) {
                        if (Code.OK.getCode().equalsIgnoreCase(list.getStatus())) {
                            NowBase now = list.getNow();
                            condCode = now.getCond_code();
                            DateTime nowTime = DateTime.now();
                            int hourOfDay = nowTime.getHourOfDay();
                            if (hourOfDay > 6 && hourOfDay < 19) {
                                ivBack.setImageResource(IconUtils.getDayBack(condCode));
                            } else {
                                ivBack.setImageResource(IconUtils.getNightBack(condCode));
                            }
                        }
                    }
                });
            }
        });
    }

