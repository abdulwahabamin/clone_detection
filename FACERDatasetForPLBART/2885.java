    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mTable = getSharedPreferences("table", MODE_PRIVATE);
        switch (item.getItemId()) {
            case R.id.toolbar_find:
                isNight = mTable.getBoolean("night", false);
                if (isNight) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    mTable.edit().putBoolean("night", false).apply();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    mTable.edit().putBoolean("night", true).apply();
                }
                recreate();
                break;
        }
        return true;
    }

