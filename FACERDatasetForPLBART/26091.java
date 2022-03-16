    /**
     * 判断有无网络正在连接中（查找网络�?校验�?获�?�IP等）。
     *
     * @return boolean �?管wifi，还是mobile net，�?�有当�?在连接状�?（�?�有效传输数�?�）�?返回true,�??之false。
     */
    public static boolean isConnectedOrConnecting(Context context) {
        NetworkInfo[] nets = getConnectivityManager(context).getAllNetworkInfo();
        if (nets != null) {
            for (NetworkInfo net : nets) {
                if (net.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

