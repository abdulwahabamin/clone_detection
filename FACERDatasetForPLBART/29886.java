    private void launchActivity(int mode) {
        preferences.setCity(cityInput.getText().toString());
        Intent intent = new Intent(getActivity(), WeatherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("mode" , mode);
        Log.i("Loaded", "Weather");
        startActivity(intent);
        Log.i("Changed", "City");
    }

