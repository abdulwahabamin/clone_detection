    public boolean networkIsOffline() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        appendLog(this, TAG, "networkIsOffline, networkInfo=", networkInfo);
        if (networkInfo == null) {
            return true;
        }
        appendLog(this, TAG, "networkIsOffline, networkInfo.isConnectedOrConnecting()=",
                networkInfo.isConnectedOrConnecting());
        return !networkInfo.isConnectedOrConnecting();
    }

