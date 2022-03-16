    /**
     * get请求
     *
     * @param url
     * @param callback
     */
    public static final void RequestGet(final String url, final StringCallback callback) {
        OkHttpUtils.get().url(url).build().execute(callback);
    }

