        @Override
        public void onMessage(String msg) {
            synchronized (mLock){
                processIncomingMsg(msg);
            }
        }

