    public void queueResponce(T t, String s) {
        if (s != null && !mConcurrentMap.containsValue(s)) {
                mConcurrentMap.put(t, s);
                mHandlerAnswer.obtainMessage(MESSAGE_DOWNLOAD, t).sendToTarget();
        } else {
            mConcurrentMap.remove(t);
            Log.d(TAG, "queueResponce: request is in queue");
        }
    }

