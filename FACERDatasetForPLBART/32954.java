    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.voice_setting_lang_opt_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

