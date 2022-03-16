    /**
     * 添加缓存
     */
    public void addCatch() {

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < mFiles.size(); i++) {
            String s = mGson.toJson(mFiles.get(i));
            strings.add(s);
        }
        for (int i = 0; i < strings.size(); i++) {
            String s = String.valueOf(i);
            mCatch.put(s, strings.get(i), ACache.TIME_DAY);
        }


        SharedPreferences.Editor edit = mPreferences.edit();
        edit.putBoolean("firstImage", false);
        edit.putInt("numImage", strings.size());
        edit.putLong("ImageTime", System.currentTimeMillis());
        edit.commit();
    }

