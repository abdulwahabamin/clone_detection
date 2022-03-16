    @Override
    public int getCount() {
        int count = 0;
        final int size = mSections.size();
        for (int i = 0; i < size; i++) {
            count += mSections.get(i).getCount() + 1;
        }
        return count;
    }

