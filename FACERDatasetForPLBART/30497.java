    private void getSearchResult(String location) {
        HeWeather.getSearch(this, location, "cn,overseas", 10, lang, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {
                Search search = new Search();
                search.setStatus("noData");
            }

            @Override
            public void onSuccess(Search search) {
                if (!search.getStatus().equals("unknown city") && !search.getStatus().equals("noData")) {
                    final List<Basic> basic = search.getBasic();
                    List<CityBean> data = new ArrayList<>();

                    if (basic != null && basic.size() > 0) {
                        if (data.size() > 0) {
                            data.clear();
                        }
                        for (int i = 0; i < basic.size(); i++) {
                            Basic basicData = basic.get(i);
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
                            data.add(cityBean);
                        }

                        SearchAdapter searchAdapter = new SearchAdapter(SearchActivity.this, data, etSearch.getText().toString(), true);
                        rvSearch.setAdapter(searchAdapter);
                        searchAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

