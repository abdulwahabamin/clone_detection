        @Override
        public void onFailure(FailureMessage failureMessage) {
            if (recount <= 0) {
                setCount();
                if (!getFileService.isShutdown()) {
                    getFileService.shutdown();
                }
            }else {
                recount--;
                executeGetFileWork(call,this);
            }
        }

