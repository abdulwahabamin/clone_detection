    @Override
    public void deliverResult(R result) {
        if (isReset()) {
            closeQuietly(result);
            return;
        }
        R oldResult = mResult;
        mResult = result;

        if (isStarted()) {
            super.deliverResult(result);
        }

        if (oldResult != null && oldResult != result) {
            closeQuietly(oldResult);
        }
    }

