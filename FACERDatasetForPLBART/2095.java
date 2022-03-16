    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible()) {
            if (childFragment != null) {
                childFragment.isVisibleFragment(isVisibleToUser);
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

