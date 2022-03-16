    @Override
    public void onDestroy() {
        super.onDestroy();
    	BLog.e("SERVICE", "BrowseService stopped");


        unregisterReceiver(pconreceiver);
        unregisterReceiver(pdisconreceiver);
        //unregisterReceiver(uforereceiver);
        unregisterReceiver(ubreceiver);
        //unregisterReceiver(ubackreceiver);

        fileObserver.stopWatching();
        SERVICE=null;
    }

