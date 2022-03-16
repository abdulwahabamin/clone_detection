    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onLongClick(View v) {
        if (v.getContentDescription() != null) {
            DialogHelper.showToast(
                    getContext(),
                    v.getContentDescription().toString(),
                    Toast.LENGTH_SHORT);
            return true;
        }
        return false;
    }

