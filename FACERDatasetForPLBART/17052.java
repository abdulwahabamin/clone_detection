    @Override
    public boolean setFirstRun(Boolean flag) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(this.mContext.getString(R.string.first_run_status_pref_key), flag);
        editor.commit();
        return flag;
    }

