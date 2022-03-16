    @Override
    public Object getItem(int position) {
        final int size = mSections.size();
        for (int i = 0; i < size; i++) {
            final SectionAdapter section = mSections.get(i);
            final int sectionSize = section.getCount() + 1;

            // Check if position inside this section
            if (position == 0) {
                return section;
            } else if (position < sectionSize) {
                return section.getItem(position - 1);
            }

            // Otherwise jump into next section
            position -= sectionSize;
        }
        throw new IllegalStateException("Unknown position " + position);
    }

