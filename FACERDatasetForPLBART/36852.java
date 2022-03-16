    public void addCounty(County county) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String countyCodeString = preferences.getString(KEY_COUNTY_CODE_STRING, "");
        List<String> codeList = splitCodeList(countyCodeString);
        L.d(TAG, "Got code list: " + codeList.toString());
        codeList.add(county.getCode());
        L.d(TAG, "Added code: " + codeList.toString());
        preferences.edit()
                .putString(KEY_COUNTY_CODE_STRING, joinCodeList(codeList))
                .apply();
    }

