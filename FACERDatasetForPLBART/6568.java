    /**
     * After mutating sections, you <em>must</em>
     * {@link AdapterView#setAdapter(android.widget.Adapter)} to correctly
     * recount view types.
     */
    public void addSection(SectionAdapter adapter) {
        mSections.add(adapter);
        notifyDataSetChanged();
    }

