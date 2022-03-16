    @Override
    public int getViewTypeCount() {
        int count = 1;
        final int size = mSections.size();
        for (int i = 0; i < size; i++) {
            count += mSections.get(i).getViewTypeCount();
        }
        return count;
    }

