    public void onSaveInstanceState(Bundle outcicle) {
        // need to store the selected item so we don't lose it in case
        // of an orientation switch. Otherwise we could lose it while
        // in the middle of specifying a playlist to add the item to.
        outcicle.putInt("selectedposition", mSelectedPosition);
        outcicle.putLong("selectedtrack", mSelectedId);

        super.onSaveInstanceState(outcicle);
    }

