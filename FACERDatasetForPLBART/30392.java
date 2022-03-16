    /**
     * 上传�?�个文件
     *
     * @param name     文件标识
     * @param fileName 文件�?? 如：lyh.png
     * @param file     上传的文件
     * @param params   需�?�?�带的�?�数
     * @param url      上传的目标地�?�
     * @param headers  需�?�?�带的请求头
     * @param callback 请求结果的回调
     */
    public static final void RequestUpFile(final String name, final int writeTimeOut, final String fileName,
                                           final File file, final HashMap<String, String> params, final String url,
                                           final HashMap<String, String> headers, final StringCallback callback) {
        if ( headers == null ) {
            OkHttpUtils.post().addFile(name, fileName, file).params(params).url(url).build().writeTimeOut(writeTimeOut).execute(callback);
        } else {
            OkHttpUtils.post().addFile(name, fileName, file).params(params).headers(headers).url(url).build().writeTimeOut(writeTimeOut).execute(callback);
        }
    }

