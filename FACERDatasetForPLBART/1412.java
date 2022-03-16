        @Override
        public void onVersion(String version) {
            synchronized (mLock){
                showInfo("Version: " + version);
            }
        }

