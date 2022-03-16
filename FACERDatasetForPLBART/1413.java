        @Override
        public void onDescription(String description) {
            synchronized (mLock){
                showIncomingMessage("Description: " + description);
            }
        }

