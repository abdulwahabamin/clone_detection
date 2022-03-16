        @Override
        public void run() {
            super.run();
            try {
                count = 0;
                while (true) {
                    count++;
                    Intent updateIntent=new Intent(ACTION_UPDATE_ALL);
                    mContext.sendBroadcast(updateIntent);
                    Thread.sleep(UPDATE_TIME);
                }
            } catch (InterruptedException e) {
                // 将 InterruptedException 定义在while循环之外，�?味�?�抛出 InterruptedException 异常时，终止线程。
                e.printStackTrace();
            }
        }

