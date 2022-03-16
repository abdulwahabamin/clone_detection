    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LifeIndexWrapper lifeIndex = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (null == convertView) {
            view = LayoutInflater.from(getContext()).inflate(mResourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.tvName.setText(lifeIndex.getLifeIndexName());
        viewHolder.tvBrief.setText(lifeIndex.getLifeIndexBrief());
        viewHolder.tvDesc.setText(lifeIndex.getLifeIndexDesc());

        return view;
    }

