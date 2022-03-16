    private boolean checkCity() {
        if (selectedCity == null) {
            String current = editField.getText().toString();
            if (current.length() > 2) {
                List<City> cities = dbHelper.getCitiesWhereNameLike(current, listLimit);
                if (cities.size() == 1) {
                    selectedCity = cities.get(0);
                    cityConsumer.accept(selectedCity);
                    return true;
                }
            }

            Toast.makeText(context, "NO City selected", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

