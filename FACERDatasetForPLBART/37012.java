    @Override
    public void onBackPressed() {
        if (currentType == CityType.PROVINCE || currentType == CityType.SEARCH) {
            view.finish();
        } else if (currentType == CityType.CITY) {
            showProvince();
        } else if (currentType == CityType.AREA) {
            showCity(currentProvince);
        }
    }

