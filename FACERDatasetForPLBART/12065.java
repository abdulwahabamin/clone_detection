        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SYNC_FS:
                    mExecutorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            sync();
                        }
                    });
                    break;

                default:
                    break;
            }
            return true;
        }

