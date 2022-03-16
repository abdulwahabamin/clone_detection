        @Override
        public void showMessage(String message, int code) {
            if (!isFinishing()) {
                return;
            }
            LogUtils.i("showMessage:"+message);
            if (mProgressDialog != null) {
                mProgressDialog.hide();
            }
            ToastUtil.showToast(mContext, getString(R.string.connect_friend_fail));
        }

