    private void getNowCity(final boolean first) {
        Lang lang;
        if (ContentUtil.APP_SETTING_LANG.equals("en") || ContentUtil.APP_SETTING_LANG.equals("sys") && ContentUtil.SYS_LANG.equals("en")) {
            lang = Lang.ENGLISH;
        } else {
            lang = Lang.CHINESE_SIMPLIFIED;
        }
        HeWeather.getSearch(this, ContentUtil.NOW_LON + "," + ContentUtil.NOW_LAT, "cn,overseas", 3, lang, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {
                List<CityBean> cityBeans = new ArrayList<>();
                CityBean cityBean = new CityBean();
                cityBean.setCityName("北京");
                cityBean.setCityId("CN101010100");
                cityBeans.add(cityBean);
                getData(cityBeans, first);
            }

            @Override
            public void onSuccess(Search search) {
                Basic basic = search.getBasic().get(0);
                String cid = basic.getCid();
                String location = basic.getLocation();
                if (first) {
                    ContentUtil.NOW_CITY_ID = cid;
                    ContentUtil.NOW_CITY_NAME = location;
                }

                List<CityBean> cityBeans = new ArrayList<>();
                CityBean cityBean = new CityBean();
                cityBean.setCityName(location);
                cityBean.setCityId(cid);

                locaitons.add(0, location);
                locaitonsEn.add(0, location);
                if (cityBeanList != null && cityBeanList.getCityBeans() != null && cityBeanList.getCityBeans().size() > 0) {
                    cityBeans = cityBeanList.getCityBeans();
                    cityBeans.add(0, cityBean);
                } else {
                    cityBeans.add(cityBean);
                }
                tvLocation.setText(location);
                getData(cityBeans, first);
            }
        });
    }

