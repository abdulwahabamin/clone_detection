        @Override
        public void onInfo(String info){
            synchronized (mLock) {
                showInfo(info);
            }
        }

