        @Override
        public void onError(Throwable e) {
            mIsDownloadSucceeded = false;
            mIsDownloadFinished = true;
            gotoNext();
        }

