    /**
     * 获�?�SP实例
     *
     * @return {@link SPUtils}
     */
    public static SPUtils init(String spName) {
        SPUtils.spName = spName;
        return getInstance();
    }

