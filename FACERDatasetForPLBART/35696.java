    public void recordingTimeTag(String tag) {
        if (mTimeTag.get(tag) != null) {
            mTimeTag.remove(tag);
        }
        long time = System.currentTimeMillis() - mStartTime;
        Log.d(TAG,tag + ":" + time);
        mTimeTag.put(tag,time);
    }

