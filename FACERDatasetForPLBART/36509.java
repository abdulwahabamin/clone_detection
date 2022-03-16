    /**
     * 查询全国所有的�?，优先从数�?�库查询，如果没有查询到�?去�?务器上查询
     */
    private void queryProvinces() {
        provinceList = simpleWeatherDB.loadProvinces();
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText("添加城市");
            currentLevel = LEVEL_PROVINCE;
        } else {
            queryFromServer(null, "province");
        }
    }

