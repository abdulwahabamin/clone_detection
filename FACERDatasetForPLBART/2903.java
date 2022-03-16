    private void initDate() {
        //开线程�?始化数�?�
        new Thread(new Runnable() {
            @Override
            public void run() {
                filename = getActivity().getIntent().getStringExtra("filename");
                mFiles = FileUtil.searchFileInDir(Environment.getExternalStorageDirectory(),filename);
                Log.d("aaa", "run: "+ mFiles.size());
               
                Message message = new Message();
                if (mFiles.size()==0) {
                    message.what = 0;
                }else 
                    message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();
    }

