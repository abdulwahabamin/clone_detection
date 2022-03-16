    @Override
    public void onResume() {
        super.onResume();

        final Context context = getActivity();
        final State state = ((DocumentsActivity) context).getDisplayState();
        state.showAdvanced = state.forceAdvanced
                | SettingsActivity.getDisplayAdvancedDevices(context);

        if (state.action == ACTION_GET_CONTENT) {
            mList.setOnItemLongClickListener(mItemLongClickListener);
        } else {
            mList.setOnItemLongClickListener(null);
            mList.setLongClickable(false);
        }

        getLoaderManager().restartLoader(2, null, mCallbacks);
    }

