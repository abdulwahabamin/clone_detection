    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityEntity entity = getItem(position);
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

        viewHolder.tvCandidateName.setText(entity.getProvince() + " - " + entity.getCity());

        return view;
    }

