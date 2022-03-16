    /**
     * query all the counties of the City selected, query from the dataBase first,
     * if no result returned, then query from the server.
     */
    private void queryCounties(){
        countyList=weatherDB.loadCounties(selectedCity.getId());
        if(countyList.size()>0){
            dataList.clear();
            for(County county:countyList){
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(selectedCity.getCityName());
            currentLevel=LEVEL_COUNTY;
        }
        else{
            queryFromServer(selectedCity.getCityCode(),"county");
        }
    }

