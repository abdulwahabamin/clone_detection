    /**
     * 判断有无�?�用状�?的移动网络，注�?关掉设备移动网络直接�?影�?此函数。
     * 也就是�?�使关掉移动网络，那么移动网络也�?�能是�?�用的(彩信等�?务)，�?�返回true。
     * 以下情况它是�?�?�用的，将返回false：
     * 1. 设备打开飞行模�?；
     * 2. 设备所在区域没有信�?�覆盖；
     * 3. 设备在漫游区域，且关闭了网络漫游。
     *
     * @return boolean
     */
    public static boolean isMobileAvailable(Context context) {
        NetworkInfo[] nets = getConnectivityManager(context).getAllNetworkInfo();
        if (nets != null) {
            for (NetworkInfo net : nets) {
                if (net.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return net.isAvailable();
                }
            }
        }
        return false;
    }

