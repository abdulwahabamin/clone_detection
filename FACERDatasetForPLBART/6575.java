    @Override
    public int getItemViewType(int position) {
        int type = 1;
        final int size = mSections.size();
        for (int i = 0; i < size; i++) {
            final SectionAdapter section = mSections.get(i);
            final int sectionSize = section.getCount() + 1;

            // Check if position inside this section
            if (position == 0) {
                return 0;
            } else if (position < sectionSize) {
                return type + section.getItemViewType(position - 1);
            }

            // Otherwise jump into next section
            position -= sectionSize;
            type += section.getViewTypeCount();
        }
        throw new IllegalStateException("Unknown position " + position);
    }

