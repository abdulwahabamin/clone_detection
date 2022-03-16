        @Override
        public void scanTimeout() {
            mScanPb.setVisibility(View.GONE);
            LogUtils.i("Scan TimeOut!");
            ToastUtil.showToast(mContext, getString(R.string.no_found_friend));
        }

