    private void addCatch() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < mFiles.size(); i++) {
            String s = mGson.toJson(mFiles.get(i));
            strings.add(s);
        }
        for (int i = 0; i < strings.size(); i++) {
            String s = String.valueOf(i);
            mCatch.put(s + "apk", strings.get(i), ACache.TIME_DAY);
        }

        SharedPreferences.Editor edit = mPreferences.edit();
        edit.putBoolean("firstApk", false);
        edit.putInt("numApk", strings.size());
        edit.putLong("ApkTime", System.currentTimeMillis());
        edit.commit();
    }

