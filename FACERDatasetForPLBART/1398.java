    private void showInfo(String info){
        Message msg = mHandler.obtainMessage(Constants.MESSAGE_TOAST);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TOAST, info);
        msg.setData(bundle);
        mHandler.sendMessage(msg);
        Log.i(TAG, info);
    }

