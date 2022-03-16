    private static int buildRunList(SparseBooleanArray cip, int rangeStart,
            int rangeEnd, int[] runStart, int[] runEnd) {
        int runCount = 0;

        int i = findFirstSetIndex(cip, rangeStart, rangeEnd);
        if (i == -1)
            return 0;

        int position = cip.keyAt(i);
        int currentRunStart = position;
        int currentRunEnd = currentRunStart + 1;
        for (i++; i < cip.size() && (position = cip.keyAt(i)) < rangeEnd; i++) {
            if (!cip.valueAt(i)) // not checked => not interesting
                continue;
            if (position == currentRunEnd) {
                currentRunEnd++;
            } else {
                runStart[runCount] = currentRunStart;
                runEnd[runCount] = currentRunEnd;
                runCount++;
                currentRunStart = position;
                currentRunEnd = position + 1;
            }
        }

        if (currentRunEnd == rangeEnd) {
            // rangeStart and rangeEnd are equivalent positions so to be
            // consistent we translate them to the same integer value. That way
            // we can check whether a run covers the entire range by just
            // checking if the start equals the end position.
            currentRunEnd = rangeStart;
        }
        runStart[runCount] = currentRunStart;
        runEnd[runCount] = currentRunEnd;
        runCount++;

        if (runCount > 1) {
            if (runStart[0] == rangeStart && runEnd[runCount - 1] == rangeStart) {
                // The last run ends at the end of the range, and the first run
                // starts at the beginning of the range. So they are actually
                // part of the same run, except they wrap around the end of the
                // range. To avoid adjacent runs, we need to merge them.
                runStart[0] = runStart[runCount - 1];
                runCount--;
            }
        }
        return runCount;
    }

