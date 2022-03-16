    private CharSequence getTitle(int i) {
        CharSequence title = mVelocityViewPager.getAdapter().getPageTitle(i);
        if (title == null) {
            title = EMPTY_TITLE;
        }
        return title;
    }

