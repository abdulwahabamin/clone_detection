    private void backToWeather(String name, boolean isAutoLocate) {
        CityInfo city = new CityInfo(name, isAutoLocate);
        Intent data = new Intent();
        data.putExtra(Extras.CITY, city);
        view.getActivity().setResult(Activity.RESULT_OK, data);
        view.finish();
    }

