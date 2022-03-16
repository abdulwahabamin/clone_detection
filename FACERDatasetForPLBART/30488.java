    @Override
    protected void onResume() {
        super.onResume();
        DataUtil.setDataInterface(this);
        if (!ContentUtil.APP_PRI_TESI.equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
            if (fragments != null && fragments.size() > 0) {
                for (Fragment fragment : fragments) {
                    WeatherFragment weatherFragment = (WeatherFragment) fragment;
                    weatherFragment.changeTextSize();
                }
            }
            if ("small".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                tvLocation.setTextSize(15);
            } else if ("large".equalsIgnoreCase(ContentUtil.APP_SETTING_TESI)) {
                tvLocation.setTextSize(17);
            } else {
                tvLocation.setTextSize(16);
            }
            ContentUtil.APP_PRI_TESI = ContentUtil.APP_SETTING_TESI;
        }
        if (ContentUtil.CHANGE_LANG) {
            if (ContentUtil.SYS_LANG.equalsIgnoreCase("en")) {
                changeLang(Lang.ENGLISH);
            } else {
                changeLang(Lang.CHINESE_SIMPLIFIED);
            }
            ContentUtil.CHANGE_LANG = false;
        }
        if (ContentUtil.CITY_CHANGE) {
            initFragments(true);
            ContentUtil.CITY_CHANGE = false;
        }
        if (ContentUtil.UNIT_CHANGE) {
            for (Fragment fragment : fragments) {
                WeatherFragment weatherFragment = (WeatherFragment) fragment;
                weatherFragment.changeUnit();
            }
            ContentUtil.UNIT_CHANGE = false;
        }
    }

