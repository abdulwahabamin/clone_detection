    @Override
    protected void onResume() {
        cp = new Preferences(this);
        prefs = new Prefs(this);
        super.onResume();

        if (!cp.getPrefs().getBoolean("first" , true)) {
            prefs.setLaunched();
            prefs.setCity(cp.getCity());
        }

        super.onResume();
        Intent intent;

        if (prefs.getLaunched()) {
            intent = new Intent(GlobalActivity.this, WeatherActivity.class);
        }
        else {
            intent = new Intent(GlobalActivity.this, FirstLaunch.class);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

