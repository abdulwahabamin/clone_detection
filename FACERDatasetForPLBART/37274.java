    @Override
    public RViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            Class<? extends RViewHolder<T>> clazz = viewHolderClassList.get(viewType);
            int resId = getLayoutResId(clazz);
            View view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
            Constructor constructor = clazz.getConstructor(View.class);
            RViewHolder<T> viewHolder = (RViewHolder<T>) constructor.newInstance(view);
            viewHolder.setAdapter(this);
            return viewHolder;
        } catch (Exception e) {
            throw new IllegalStateException("create view holder error", e);
        }
    }

