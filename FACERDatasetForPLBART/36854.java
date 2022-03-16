    public List<County> getCounties() {
        List<String> codeList = splitCodeList(
                PreferenceManager.getDefaultSharedPreferences(mContext).getString(KEY_COUNTY_CODE_STRING, ""));
        List<County> countyList = new ArrayList<>();
        if (codeList.size() > 0) {
            CountyDAO dao = new CountyDAO(mContext);
            for (String code : codeList) {
                County county = dao.query(code);
                if (county != null) {
                    countyList.add(county);
                }
            }
            dao.close();
        }
        return countyList;
    }

