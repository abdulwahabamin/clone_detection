    /**
     * 判断是�?�有�?�用状�?的Wifi，以下情况返回false：
     * 1. 设备wifi开关关掉;
     * 2. 已�?打开飞行模�?；
     * 3. 设备所在区域没有信�?�覆盖；
     * 4. 设备在漫游区域，且关闭了网络漫游。
     *
     * @return boolean wifi为�?�用状�?（�?一定�?功连接，�?�Connected）�?�返回ture
     */
    public static boolean isWifiAvailable(Context context) {
        NetworkInfo[] nets = getConnectivityManager(context).getAllNetworkInfo();
        if (nets != null) {
            for (NetworkInfo net : nets) {
                if (net.getType() == ConnectivityManager.TYPE_WIFI) {
                    return net.isAvailable();
                }
            }
        }
        return false;
    }

