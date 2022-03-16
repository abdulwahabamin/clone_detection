    /**
     * 判断网络连接是�?�有效（此时�?�传输数�?�）。
     *
     * @return boolean �?管wifi，还是mobile net，�?�有当�?在连接状�?（�?�有效传输数�?�）�?返回true,�??之false。
     */
    public static boolean isConnected(Context context) {
        NetworkInfo net = getConnectivityManager(context).getActiveNetworkInfo();
        return net != null && net.isConnected();
    }

