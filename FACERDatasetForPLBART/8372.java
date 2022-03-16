    /**
     * {@inheritDoc}
     */
    @Override
    public void onBackPressed() {
       if (mExecutable != null) {
            mExecutable.end();
       }
       back(true, null, false);
    }

