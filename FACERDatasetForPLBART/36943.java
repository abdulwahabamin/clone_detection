    @Override
    public void refresh() {
        aCache = (ACache) adapter.getTag();
        tvCity.setText(data.name);
        ivLocate.setVisibility(data.isAutoLocate ? View.VISIBLE : View.GONE);
        CityInfo currentCity = (CityInfo) aCache.getAsObject(Extras.CITY);
        tvRemark.setText(data.equals(currentCity) ? "当�?城市" : "");
    }

