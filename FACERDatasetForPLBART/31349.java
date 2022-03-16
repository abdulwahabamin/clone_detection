        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            mView.hideLoading();
            mView.showRetry();
        }

