        @Override
        public void bondFail() {
            mProgressDialog.hide();
            LogUtils.i("bondFail");
            ToastUtil.showToast(mContext, getString(R.string.add_friend_fail));
        }

