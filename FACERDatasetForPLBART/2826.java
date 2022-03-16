    public ImageAdapter(Context context, List<File> Data) {
        this.mDatas = Data;
        this.mContext = context;
        this.mGson = new Gson();
        mHeights = new ArrayList<Integer>();
        try {
            mCache = ACache.get(mContext);
        } catch (Exception e) {
            //�?线程未销�?�?�能时执行
        }
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (300 + Math.random() * 500));
        }
    }

