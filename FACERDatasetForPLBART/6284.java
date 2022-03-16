    public void setRootsDrawerOpen(boolean open) {
        if (!mShowAsDialog) {
            if (open) {
                mDrawerLayout.openDrawer(mRootsContainer);
            } else {
                mDrawerLayout.closeDrawer(mRootsContainer);
            }
        }
    }

