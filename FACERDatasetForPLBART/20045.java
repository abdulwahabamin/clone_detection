    /**
     * Use this to move the check state of an item from one position to another
     * in a drop operation. If you have a choiceMode which is not none, this
     * method must be called when the order of items changes in an underlying
     * adapter which does not have stable IDs (see
     * {@link ListAdapter#hasStableIds()}). This is because without IDs, the
     * ListView has no way of knowing which items have moved where, and cannot
     * update the check state accordingly.
     * <p>
     * A word of warning about a "feature" in Android that you may run into when
     * dealing with movable list items: for an adapter that <em>does</em> have
     * stable IDs, ListView will attempt to locate each item based on its ID and
     * move the check state from the item's old position to the new position —
     * which is all fine and good (and removes the need for calling this
     * function), except for the half-baked approach. Apparently to save time in
     * the naive algorithm used, ListView will only search for an ID in the
     * close neighborhood of the old position. If the user moves an item too far
     * (specifically, more than 20 rows away), ListView will give up and just
     * force the item to be unchecked. So if there is a reasonable chance that
     * the user will move items more than 20 rows away from the original
     * position, you may wish to use an adapter with unstable IDs and call this
     * method manually instead.
     * 
     * @param from
     * @param to
     */
    public void moveCheckState(int from, int to) {
        // This method runs in O(n log n) time (n being the number of list
        // items). The bottleneck is the call to AbsListView.setItemChecked,
        // which is O(log n) because of the binary search involved in calling
        // SparseBooleanArray.put().
        //
        // To improve on the average time, we minimize the number of calls to
        // setItemChecked by only calling it for items that actually have a
        // changed state. This is achieved by building a list containing the
        // start and end of the "runs" of checked items, and then moving the
        // runs. Note that moving an item from A to B is essentially a rotation
        // of the range of items in [A, B]. Let's say we have
        // . . U V X Y Z . .
        // and move U after Z. This is equivalent to a rotation one step to the
        // left within the range you are moving across:
        // . . V X Y Z U . .
        //
        // So, to perform the move we enumerate all the runs within the move
        // range, then rotate each run one step to the left or right (depending
        // on move direction). For example, in the list:
        // X X . X X X . X
        // we have two runs. One begins at the last item of the list and wraps
        // around to the beginning, ending at position 1. The second begins at
        // position 3 and ends at position 5. To rotate a run, regardless of
        // length, we only need to set a check mark at one end of the run, and
        // clear a check mark at the other end:
        // X . X X X . X X
        SparseBooleanArray cip = getCheckedItemPositions();
        int rangeStart = from;
        int rangeEnd = to;
        if (to < from) {
            rangeStart = to;
            rangeEnd = from;
        }
        rangeEnd += 1;

        int[] runStart = new int[cip.size()];
        int[] runEnd = new int[cip.size()];
        int runCount = buildRunList(cip, rangeStart, rangeEnd, runStart, runEnd);
        if (runCount == 1 && (runStart[0] == runEnd[0])) {
            // Special case where all items are checked, we can never set any
            // item to false like we do below.
            return;
        }

        if (from < to) {
            for (int i = 0; i != runCount; i++) {
                setItemChecked(rotate(runStart[i], -1, rangeStart, rangeEnd), true);
                setItemChecked(rotate(runEnd[i], -1, rangeStart, rangeEnd), false);
            }

        } else {
            for (int i = 0; i != runCount; i++) {
                setItemChecked(runStart[i], false);
                setItemChecked(runEnd[i], true);
            }
        }
    }

