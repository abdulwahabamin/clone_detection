    private Interceptor cacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {

                Request request = chain.request();

                if (!NetWork.isAvailable(CoreManager.getContext())) {
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }
                Response originalResponse = chain.proceed(request);

                if (NetWork.isAvailable(CoreManager.getContext())) {
                    return originalResponse.newBuilder().header("Cache-Control", "public ,max-age=" + MAX_AGE).build();
                } else {
                    return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + MAX_STALE).build();
                }
            }
        };
    }

