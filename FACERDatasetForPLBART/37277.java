    @Override
    public int getItemViewType(int position) {
        Class<? extends RViewHolder<T>> clazz = delegate.getViewHolderClass(position);
        if (!viewHolderClassList.contains(clazz)) {
            viewHolderClassList.add(clazz);
        }
        return viewHolderClassList.indexOf(clazz);
    }

