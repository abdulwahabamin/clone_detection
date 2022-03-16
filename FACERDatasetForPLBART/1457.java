    private void reconnect(){
        Message msg = mHandler.obtainMessage(Constants.MESSAGE_TOAST);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TOAST, "Trying to reconnect...");
        msg.setData(bundle);
        mHandler.sendMessage(msg);

    }

