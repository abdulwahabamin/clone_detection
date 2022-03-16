    /**
     * query all provinces of the country firstly in database, if the result returned is null,
     * then query from the server.
     */
    private void queryProvinces(){
        provinceList=weatherDB.loadProvinces();
        if(provinceList.size()>0){
            dataList.clear();
            for(Province province:provinceList){
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText("中国");
            currentLevel=LEVEL_PROVINCE;
        }
        else {
            queryFromServer(null,"province");
        }
    }

