    /**
     * Get the current order of Cursor positions presented by the
     * list.
     */
    public List<Integer> getCursorPositions() {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < getCount(); i++) {
            result.add(mListMapping.get(i, i));
        }

        return result;
    }

