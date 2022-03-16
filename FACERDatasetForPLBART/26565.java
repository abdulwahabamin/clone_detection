    public void launchDetails(View v) {
        switch (v.getId()) {
            case R.id.viewmorebtn:
                startActivity(new Intent(this, DailyForecastActivity.class));
                break;
        }
    }

