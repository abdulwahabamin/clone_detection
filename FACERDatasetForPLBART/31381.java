        @Override
        public void onCompleted() {
            mIsDownloadSucceeded = true;
            mIsDownloadFinished = true;
            gotoNext();
        }

