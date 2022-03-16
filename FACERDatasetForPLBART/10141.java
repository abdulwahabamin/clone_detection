    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onLongClick(View v) {
        DialogHelper.showToast(getContext(), this.mItemPath, Toast.LENGTH_SHORT);
        return true;
    }

