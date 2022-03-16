    @Override
    public void onBackPressed() {

        if(mDrawerLayout.isDrawerOpen(Gravity.START)) { // Close left drawer if opened
            mDrawerLayout.closeDrawer(Gravity.START);

        } else if (getCurrentFragmentId()==Common.FOLDERS_FRAGMENT) {
            if (((FilesFoldersFragment) mCurrentFragment).getCurrentDir().equals("/"))
                super.onBackPressed();
            else
                ((FilesFoldersFragment) mCurrentFragment).getParentDir();

        } else {
            super.onBackPressed();
        }

    }

