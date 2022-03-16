        @Override
        public void onData(byte [] data){
            synchronized (mLock) {
                save2File(data);
            }
        }

