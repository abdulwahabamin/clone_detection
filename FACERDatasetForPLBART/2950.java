    private void judge() {
        try {
            mPreferences = getContext().getSharedPreferences("table", Context.MODE_PRIVATE);
        } catch (Exception e) {
            //�?线程未销�?�?�能时执行
        }

        boolean first = mPreferences.getBoolean("firstZip", true);
        int num = mPreferences.getInt("numZip", 0);
        
        long time = mPreferences.getLong("ZipTime", 0);
        long cha = System.currentTimeMillis() - time;
        //判断缓存时间是�?�过期

        if (!first && time != 0 & cha < 86400000) {
            for (int i = 0; i < num; i++) {
                String s = String.valueOf(i);
                String string = mCatch.getAsString(s + "zip");
                if (string!=null) {
                    File file = mGson.fromJson(string, File.class);
                    mFiles.add(file);
                }

            }
        } else {

            mFiles = FileUtils.listFilesInDirWithFilter(Environment.getExternalStorageDirectory(), ".zip");
            addCatch();
        }
    }

