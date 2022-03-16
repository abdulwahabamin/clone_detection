    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // If we already have this item instantiated, there is nothing
        // to do.  This can happen when we are restoring the entire pager
        // from its saved state, where the fragment manager has already
        // taken care of restoring the fragments we previously had instantiated.
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }

        Fragment fragment = getItem(position);
        if (DEBUG) Log.v(TAG, "Adding item #" + position + ": f=" + fragment);
        /*if (mSavedState.size() > position) {
            Fragment.SavedState fss = mSavedState.get(position);
            if (fss != null) {
                fragment.setInitialSavedState(fss);
            }
        }*/

        /*fragment.setMenuVisibility(false);
        fragment.setUserVisibleHint(false);*/
        fragment.setUserVisibleHint(true);
        fragment.setMenuVisibility(true);
        mCurTransaction.add(container.getId(), fragment);
        Log.d("instantiateItem","fragment "+position+" is visible :"+fragment.getUserVisibleHint());

        return fragment;
    }

