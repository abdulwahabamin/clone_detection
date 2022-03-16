    private void restorePreviousCity() {
        if (!TextUtils.isEmpty(activity.recentCityId)) {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putString("cityId", activity.recentCityId);
            editor.commit();
            activity.recentCityId = "";
        }
    }

