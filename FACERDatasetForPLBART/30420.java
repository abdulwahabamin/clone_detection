    /**
     * 获�?�当�?的网络状�? ：没有网络-0：WIFI网络1：4G网络-4：3G网络-3：2G网络-2
     * 自定义
     */
    public static boolean getAPNType(Context context) {
        boolean netType;
        //获�?�手机所有连接管�?�对象
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获�?�NetworkInfo对象
        NetworkInfo networkInfo = null;
        if (manager != null) {
            networkInfo = manager.getActiveNetworkInfo();
        }
        //NetworkInfo对象为空 则代表没有网络
        if (networkInfo == null) {
            //无网络
            netType = false;
        } else {
            //有网
            netType = true;
        }
        return netType;
    }

