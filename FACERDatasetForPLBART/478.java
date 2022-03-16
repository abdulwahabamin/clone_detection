        @Override
        public void bonded() {
            mProgressDialog.dismiss();
            LogUtils.i("bonded");
            ToastUtil.showToast(mContext, getString(R.string.add_friend_success));
            finish();
        }

