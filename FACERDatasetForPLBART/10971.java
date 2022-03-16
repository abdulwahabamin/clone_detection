    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
          return true;
        }

        if (mNeedsEasyMode) {
            if (item.getItemId() == android.R.id.home) {
                if (mHistory.size() == 0 && !isEasyModeVisible()) {
                    performShowEasyMode();
                } else {
                    back();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

