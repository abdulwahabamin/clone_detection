        @Override
        public void connectStateChange(State state) {
            LogUtils.i("connectStateChange:"+state.getCode());
            if(state == State.STATE_CONNECTED){
                if (mProgressDialog != null) {
                    mProgressDialog.hide();
                }
                if(mFriendInfo != null){
                    mTitleTv.setText(mFriendInfo.getFriendNickName()+"("+getString(R.string.device_online)+")");
                }
                ToastUtil.showToast(mContext, getString(R.string.connect_friend_success));
            }
        }

