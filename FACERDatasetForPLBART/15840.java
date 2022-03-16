        public void deleteGroup(){
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.deleteGroup();
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

