    private static int findFirstSetIndex(SparseBooleanArray sba, int rangeStart, int rangeEnd) {
        int size = sba.size();
        int i = insertionIndexForKey(sba, rangeStart);
        while (i < size && sba.keyAt(i) < rangeEnd && !sba.valueAt(i))
            i++;
        if (i == size || sba.keyAt(i) >= rangeEnd)
            return -1;
        return i;
    }

