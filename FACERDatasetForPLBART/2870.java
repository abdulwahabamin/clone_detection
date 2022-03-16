    public ZipAdapter(Context context, List<File> Data) {
        this.mDatas = Data;
        this.mContext = context;
        this.mGson = new Gson();
        try {
            mCache = ACache.get(mContext);
        }catch (Exception e){
            //�?线程未销�?�?�能时执行
        }
    }

