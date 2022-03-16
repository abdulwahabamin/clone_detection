    /**
     * Use this when an item has been deleted, to move the check state of all
     * following items up one step. If you have a choiceMode which is not none,
     * this method must be called when the order of items changes in an
     * underlying adapter which does not have stable IDs (see
     * {@link ListAdapter#hasStableIds()}). This is because without IDs, the
     * ListView has no way of knowing which items have moved where, and cannot
     * update the check state accordingly.
     * 
     * See also further comments on {@link #moveCheckState(int, int)}.
     * 
     * @param position
     */
    public void removeCheckState(int position) {
        SparseBooleanArray cip = getCheckedItemPositions();

        if (cip.size() == 0)
            return;
        int[] runStart = new int[cip.size()];
        int[] runEnd = new int[cip.size()];
        int rangeStart = position;
        int rangeEnd = cip.keyAt(cip.size() - 1) + 1;
        int runCount = buildRunList(cip, rangeStart, rangeEnd, runStart, runEnd);
        for (int i = 0; i != runCount; i++) {
            if (!(runStart[i] == position || (runEnd[i] < runStart[i] && runEnd[i] > position))) {
                // Only set a new check mark in front of this run if it does
                // not contain the deleted position. If it does, we only need
                // to make it one check mark shorter at the end.
                setItemChecked(rotate(runStart[i], -1, rangeStart, rangeEnd), true);
            }
            setItemChecked(rotate(runEnd[i], -1, rangeStart, rangeEnd), false);
        }
    }

