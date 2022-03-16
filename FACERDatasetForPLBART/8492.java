    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean onLongClick(View v) {
        if (this.mOnItemLongClickListener != null) {
            String[] data = v.getTag().toString().split("[|]"); //$NON-NLS-1$
            return this.mOnItemLongClickListener.onItemLongClick(
                    (AdapterView<TwoColumnsMenuListAdapter>)v.getParent().getParent(),
                    v, Integer.parseInt(data[0]), Long.parseLong(data[1]));
        }
        return false;
    }

