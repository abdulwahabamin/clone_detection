    private void saveData(Lang lang, final String key, final String cid) {
        HeWeather.getSearch(activity, cid, "cn,overseas", 1, lang, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.i("sky", "onError: ");
                activity.onBackPressed();
            }

            @Override
            public void onSuccess(Search search) {
                List<CityBean> citys = new ArrayList<>();
                if (!search.getStatus().equals("unknown city") && !search.getStatus().equals("noData")) {
                    List<Basic> basic = search.getBasic();
                    Basic basicData = basic.get(0);
                    String parentCity = basicData.getParent_city();
                    String adminArea = basicData.getAdmin_area();
                    String cnty = basicData.getCnty();
                    if (TextUtils.isEmpty(parentCity)) {
                        parentCity = adminArea;
                    }
                    if (TextUtils.isEmpty(adminArea)) {
                        parentCity = cnty;
                    }
                    CityBean cityBean = new CityBean();
                    cityBean.setCityName(parentCity + " - " + basicData.getLocation());
                    cityBean.setCityId(basicData.getCid());
                    cityBean.setCnty(cnty);
                    cityBean.setAdminArea(adminArea);

                    cityBeanList = SpUtils.getBean(activity, key, CityBeanList.class);
                    if (cityBeanList != null && cityBeanList.getCityBeans() != null) {
                        citys = cityBeanList.getCityBeans();
                    }
                    for (int i = 0; i < citys.size(); i++) {
                        if (citys.get(i).getCityId().equals(cid)) {
                            citys.remove(i);
                        }
                    }
                    if (citys.size() == 10) {
                        citys.remove(9);
                    }
                    citys.add(0, cityBean);
                    CityBeanList cityBeans = new CityBeanList();
                    cityBeans.setCityBeans(citys);
                    SpUtils.saveBean(activity, key, cityBeans);
                    DataUtil.setCid(cid);
                }
            }
        });
    }

