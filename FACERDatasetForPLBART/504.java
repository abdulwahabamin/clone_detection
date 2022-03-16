    @Override
    protected void initData() {
        mFriendInfo = this.getIntent().getParcelableExtra(AppConstant.FRIEND_INFO);
        if (mFriendInfo == null) {
            return;
        }
        if(mFriendInfo.isOnline()){
            mTitleTv.setText(mFriendInfo.getFriendNickName()+"("+getString(R.string.device_online)+")");
        } else{
            mTitleTv.setText(mFriendInfo.getFriendNickName()+"("+getString(R.string.device_offline)+")");
        }
        mChatAdapter = new ChatAdapter(mContext);
        mChatMsgLv.setAdapter(mChatAdapter);

        mBluetoothChatHelper = new BluetoothChatHelper(chatCallback);
        mProgressDialog.setMessage(getString(R.string.connect_friend_loading));
        if(!isFinishing() && !mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mBluetoothChatHelper.connect(mFriendInfo.getBluetoothDevice(), false);
            }
        }, 3000);
    }

