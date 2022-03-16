    @Override
    public void deliverResult(Collection<RootInfo> result) {
        if (isReset()) {
            return;
        }
        Collection<RootInfo> oldResult = mResult;
        mResult = result;

        if (isStarted()) {
            super.deliverResult(result);
        }
    }

