    private void initData() {
        //开线程�?始化数�?�

        new Thread(new Runnable() {

            @Override
            public void run() {
                judge();
                Message message = new Message();
                message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();
    }

