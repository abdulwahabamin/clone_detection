    private boolean hasAutoLocate() {
        ACache aCache = ACache.get(view.getContext());
        ArrayList<CityInfo> cityList = (ArrayList<CityInfo>) aCache.getAsObject(Extras.CITY_LIST);
        for (CityInfo entity : cityList) {
            if (entity.isAutoLocate) {
                return true;
            }
        }
        return false;
    }

