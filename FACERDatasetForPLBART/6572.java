    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int size = mSections.size();
        for (int i = 0; i < size; i++) {
            final SectionAdapter section = mSections.get(i);
            final int sectionSize = section.getCount() + 1;

            // Check if position inside this section
            if (position == 0) {
                return section.getHeaderView(convertView, parent);
            } else if (position < sectionSize) {
                return section.getView(position - 1, convertView, parent);
            }

            // Otherwise jump into next section
            position -= sectionSize;
        }
        throw new IllegalStateException("Unknown position " + position);
    }

