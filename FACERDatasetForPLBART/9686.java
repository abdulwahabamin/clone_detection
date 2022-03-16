    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        if (!TextUtils.isEmpty(mCurrentDir)) {
            return new File(this.mCurrentDir).getName();
        }
        return null;
    }

