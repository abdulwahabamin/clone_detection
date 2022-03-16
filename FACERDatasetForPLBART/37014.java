    @Override
    public List<String> getAddedCity() {
        if (addedCityList == null) {
            addedCityList = model.getAddedCity(view.getContext());
        }
        return addedCityList;
    }

