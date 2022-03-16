    private void crateReadThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true && !stop) {


                        int length = 0;

                        while (length == 0 && !stop) {
                            length = mInputStream.available();
                        }

                        byte[] bytes = new byte[length];


                        mInputStream.read(bytes);

                        String text = new String(bytes, "UTF-8");

                        Log.i(TAG, "receive:" + text);

                        Message msg = mainHandler.obtainMessage();

                        msg.obj = text;

                        msg.what = READ_DATA_SUCCESS;

                        mainHandler.sendMessage(msg);
                    }

                } catch (IOException e) {
                    mainHandler.sendEmptyMessage(READ_DATA_FAIL);
                    e.printStackTrace();
                }
            }
        }).start();
    }

