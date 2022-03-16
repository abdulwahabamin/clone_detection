    private boolean isInCityList(String name) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            str.add(cityList.get(i).getCityName());
        }
        return str.contains(name);
    }

