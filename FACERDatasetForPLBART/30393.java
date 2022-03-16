    /**
     * 上传多个文件
     *
     * @param key      本次上传的唯一标识
     * @param files    上传的文件，String类型的key为文件�??， 如:lyh.png , File类型的value是上传的文件
     * @param params   需�?�?�带的�?�数
     * @param url      上传的目标地�?�
     * @param headers  需�?�?�带的请求头信�?�
     * @param callback �?务器�?应结果的回调
     */
    public static final void RequestUpFiles(final String key, final HashMap<String, File> files,
                                            final HashMap<String, String> params, final String url,
                                            final HashMap<String, String> headers, final StringCallback callback) {
        if ( headers == null ) {
            OkHttpUtils.post().files(key, files).params(params).url(url).build().execute(callback);
        } else {
            OkHttpUtils.post().files(key, files).params(params).headers(headers).url(url).build().execute(callback);
        }
    }

