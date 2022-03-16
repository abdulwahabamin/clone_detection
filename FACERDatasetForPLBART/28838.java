    public void getCityFromText(Boolean selectWhenUnique) {
        selectedCity = null;
        cityConsumer.accept(null);
        if (dbHelper != null) {
            //List<City> allCities = dbHelper.getAllCities();

            String content = editField.getText().toString();
            if (content.length() > 2) {
                // Get the matched cities
                //List<City> cities = dbHelper.getCitiesWhereNameLike(content, allCities, dropdownListLimit);
                List<City> cities = dbHelper.getCitiesWhereNameLike(content, listLimit);
                // Set the drop down entries

                if (selectWhenUnique && cities.size() == 1) {
                    selectedCity = cities.get(0);
                    cityConsumer.accept(selectedCity);
                } else {
                    cityAdapter.clear();
                    cityAdapter.addAll(cities);
                    editField.showDropDown();
                }
            } else {
                editField.dismissDropDown();
            }
        }
    }

