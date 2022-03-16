    private void judge() {
        try {
            mPreferences = getContext().getSharedPreferences("table", Context.MODE_PRIVATE);
        } catch (Exception e) {
            //�?线程未销�?�?�能时执行
        }

        boolean first = mPreferences.getBoolean("firstApk", true);
        int num = mPreferences.getInt("numApk", 0);

        long time = mPreferences.getLong("ApkTime", 0);
        long cha = System.currentTimeMillis() - time;
        //判断缓存时间是�?�过期

        if (!first && time != 0 & cha < 86400000) {
            for (int i = 0; i < num; i++) {
                String s = String.valueOf(i);
                String string = mCatch.getAsString(s + "apk");
                if (string!=null) {
                    Log.d("aaa", "judge: ++++++++==" );
                    File file = mGson.fromJson(string, File.class);
                    mFiles.add(file);
                }

            }
        } else {

            mFiles = FileUtils.listFilesInDirWithFilter(Environment.getExternalStorageDirectory(), ".apk");
            addCatch();
        }
    }

