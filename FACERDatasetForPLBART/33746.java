    /**
     * Remove unnecessary mappings from sparse array.
     */
    private void cleanMapping() {
        List<Integer> toRemove = new ArrayList<Integer>();

        final int size = mListMapping.size();
        for (int i = 0; i < size; i++) {
            if (mListMapping.keyAt(i) == mListMapping.valueAt(i)) {
                toRemove.add(mListMapping.keyAt(i));
            }
        }

        for (int position : toRemove) {
        	mListMapping.delete(position);
        }
    }

