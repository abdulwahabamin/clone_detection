    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case MSG_SET_PATH: {
                String path = (String)message.obj;

                if (mFis != null && mPath.equals(path) == false) {
                    // current file does not match requested one: clean it
                    try {
                        mFis.close();
                    } catch (IOException e) {
                        Log.e("VanillaMusic", "Failed to close file: "+e);
                    }
                    mFis = null;
                    mPath = null;
                }

                if (mFis == null) {
                    // need to open new input stream
                    try {
                        FileInputStream fis = new FileInputStream(path);
                        mFis = fis;
                        mPath = path;
                    } catch (FileNotFoundException e) {
                        Log.e("VanillaMusic", "Failed to open file "+path+": "+e);
                    }
                }

                if (mFis != null) {
                    mHandler.sendEmptyMessage(MSG_READ_CHUNK);
                }
                break;
            }
            case MSG_READ_CHUNK: {
                int bytesRead = -1;
                try {
                    bytesRead = mFis.read(mScratch);
                } catch (IOException e) {
                    // fs error or eof: stop in any case
                }
                if (bytesRead >= 0) {
                    mHandler.sendEmptyMessageDelayed(MSG_READ_CHUNK, MS_DELAY_PER_READ);
                } else {
                    Log.d("VanillaMusic", "Readahead for "+mPath+" finished");
                }
            }
            default: {
                break;
            }
        }
        return true;
    }

