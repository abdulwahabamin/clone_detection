    public void getTotalSpace() {
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        float i = 1024 * 1024 * 1024;
        float bytes = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bytes = sf.getTotalBytes() / i;
        } else {
            Toast.makeText(this, "您的手机版本太低，暂时�?支�?内存查询", Toast.LENGTH_SHORT).show();
        }
        DecimalFormat df = new DecimalFormat("0.00");//格�?化�?数
        mToalS = df.format(bytes);
        mTotalView.setText(mToalS);
    }

