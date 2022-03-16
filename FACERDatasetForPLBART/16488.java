    /**
     * èŽ·å?–SPå®žä¾‹
     *
     * @return {@link SPUtils}
     */
    public static SPUtils getInstance() {
        if (isSpace(spName)) {
            spName = "default_share_pref";
        }
        SPUtils spUtils = SP_UTILS_MAP.get(spName);
        if (spUtils == null) {
            spUtils = new SPUtils(spName);
            SP_UTILS_MAP.put(spName, spUtils);
        }
        return spUtils;
    }

