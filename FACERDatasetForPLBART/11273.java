    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public void onClick(View v) {
        if (this.mOnItemClickListener != null) {
            String[] data = v.getTag().toString().split("[|]"); //$NON-NLS-1$
            this.mOnItemClickListener.onItemClick(
                    (AdapterView<TwoColumnsMenuListAdapter>)v.getParent().getParent(),
                    v, Integer.parseInt(data[0]), Long.parseLong(data[1]));
        }
    }

