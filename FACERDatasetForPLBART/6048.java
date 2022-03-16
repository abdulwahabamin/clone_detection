    /**
     * 判断缓存是�?�存在，�?始化数�?�
     */
    private void judge() {
        try {
            mPreferences = getContext().getSharedPreferences("table", Context.MODE_PRIVATE);
        } catch (Exception e) {
            //�?线程未销�?�?�能时执行
        }
        boolean first = mPreferences.getBoolean("firstImage", true);
        int num = mPreferences.getInt("numImage", 0);

        long time = mPreferences.getLong("ImageTime", 0);
        long cha = System.currentTimeMillis() - time;
        //判断缓存时间是�?�过期

        if (!first && time != 0 & cha < 86400000) {
            for (int i = 0; i < num; i++) {
                String s = String.valueOf(i);
                String string = mCatch.getAsString(s);
                if (string!=null) {
                    File file = mGson.fromJson(string, File.class);
                    mFiles.add(file);
                }

            }
        } else {

            mFiles = FileUtils.listFilesInDirWithFilter(Environment.getExternalStorageDirectory(), ".jpg");
            addCatch();
        }
    }

