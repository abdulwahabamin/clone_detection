    public void getFreeSpace() {
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        float i = 1024 * 1024 * 1024;
        float bytes = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bytes = sf.getFreeBytes() / i;
        }
        DecimalFormat df = new DecimalFormat("0.00");//æ ¼å¼?åŒ–å°?æ•°
        mFreeS = df.format(bytes);
        mFreeView.setText(mFreeS);
    }

