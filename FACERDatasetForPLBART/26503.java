    /**
     * 查询接�?�的实现类是�?�存在，除�?�特殊情况，一般�?需�?，直接调用{@link #getImpl}就行了
     */
    public static <T extends ICoreApi> boolean implExist(Class<T> api) {
        return Hub.implExist(api);
    }

