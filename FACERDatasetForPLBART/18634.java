    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(mContext)
                             .registerReceiver((mReceiver), new IntentFilter(Common.UPDATE_UI_BROADCAST));

    }

