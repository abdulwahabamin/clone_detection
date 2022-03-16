    public static NetWork.NetType getConnectedType(Context context) {
        NetworkInfo net = getConnectivityManager(context).getActiveNetworkInfo();
        if (net != null) {
            switch (net.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return NetWork.NetType.Wifi;
                case ConnectivityManager.TYPE_MOBILE:
                    return NetWork.NetType.Mobile;
                default:
                    return NetWork.NetType.Other;
            }
        }
        return NetWork.NetType.None;
    }

