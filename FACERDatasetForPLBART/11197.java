    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        ViewHolder viewHolder = (ViewHolder)v.getTag();
        this.mOnItemClickListener.onItemClick(this.mParent, v, viewHolder.mPosition, v.getId());
    }

