    private void initFragments(boolean first) {
        cityBeanList = SpUtils.getBean(MainActivity.this, "cityBean", CityBeanList.class);
        CityBeanList cityBeanEn = SpUtils.getBean(MainActivity.this, "cityBeanEn", CityBeanList.class);
        CityBeanList cityBean = SpUtils.getBean(MainActivity.this, "cityBean", CityBeanList.class);
        locaitonsEn = new ArrayList<>();
        locaitons = new ArrayList<>();
        if (cityBeanEn != null) {
            for (CityBean city : cityBeanEn.getCityBeans()) {
                String cityName = city.getCityName();
                locaitonsEn.add(cityName);
            }
        }
        if (cityBean != null) {
            for (CityBean city : cityBean.getCityBeans()) {
                String cityName = city.getCityName();
                locaitons.add(cityName);
            }
        }
        cityIds = new ArrayList<>();
        fragments = new ArrayList<>();
        if (first) {
            initLocation();
        } else {
            getNowCity(false);
        }

    }

