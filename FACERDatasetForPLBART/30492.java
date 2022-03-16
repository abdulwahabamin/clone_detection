    private void changeLang(final Lang lang) {
        HeWeather.getSearch(this, ContentUtil.NOW_LON + "," + ContentUtil.NOW_LAT, "cn,overseas", 3, lang, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onSuccess(Search search) {
                Basic basic = search.getBasic().get(0);
                String location = basic.getLocation();

                if (lang == Lang.ENGLISH) {
                    locaitonsEn.remove(0);
                    locaitonsEn.add(0, location);
                    tvLocation.setText(locaitonsEn.get(mNum));
                }else if (lang == Lang.CHINESE_SIMPLIFIED){
                    locaitons.remove(0);
                    locaitons.add(0, location);
                    tvLocation.setText(locaitons.get(mNum));
                }
            }
        });
    }

