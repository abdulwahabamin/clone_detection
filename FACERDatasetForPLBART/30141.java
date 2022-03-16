    private void saveBean(final String key, String cid, int x) {
        List<CityBean> citys = new ArrayList<>();
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
        citys.add(0, data.get(x));
        CityBeanList cityBeans = new CityBeanList();
        cityBeans.setCityBeans(citys);
        SpUtils.saveBean(activity, key, cityBeans);

    }

