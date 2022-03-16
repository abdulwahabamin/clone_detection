    public void removeCounty(County county) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        List<String> codeList = splitCodeList(preferences.getString(KEY_COUNTY_CODE_STRING, ""));
        for (int i = 0; i < codeList.size(); i++) {
            if (codeList.get(i).equals(county.getCode())) {
                codeList.remove(i);
            }
        }
        preferences.edit()
                .putString(KEY_COUNTY_CODE_STRING, joinCodeList(codeList))
                .apply();
    }

