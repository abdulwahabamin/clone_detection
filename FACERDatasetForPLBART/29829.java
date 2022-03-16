    @Override
    public void onBackPressed() {
        if (isStateChanged())
            startActivity(new Intent(this , WeatherActivity.class));
        else
            finish();
    }

