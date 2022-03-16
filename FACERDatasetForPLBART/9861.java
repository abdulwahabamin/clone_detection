    /**
     * {@inheritDoc}
     */
    @Override
    public void onException(Exception cause) {
        ExceptionUtil.translateException(this.mContext, cause, false, false);
    }

