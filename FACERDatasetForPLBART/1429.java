        @Override
        public void onInitRfcommSocket(){
            synchronized (mLock) {
                ensureDiscoverable();
                showInfo("RFCOMM: Socket listening...");
            }
        }

