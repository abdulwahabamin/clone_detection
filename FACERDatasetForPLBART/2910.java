    private void initDate() {
        //开线程�?始化数�?�
        new Thread(new Runnable() {
            @Override
            public void run() {
                filetype = getActivity().getIntent().getStringExtra("filetype");
                mFiles = FileUtils.listFilesInDirWithFilter(Environment.getExternalStorageDirectory(), "." + filetype);

                Log.d("aaa", "run: " + mFiles.size());

                Message message = new Message();
                if (mFiles.size() == 0) {
                    message.what = 0;
                } else
                    message.what = 1;
                myHandler.sendMessage(message);
            }
        }).start();
    }

