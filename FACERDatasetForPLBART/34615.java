    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProvinceViewHolder viewHolder = new ProvinceViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_province, parent,false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.province_name);
            viewHolder.arrow = (ImageView) convertView.findViewById(R.id.enter);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ProvinceViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(provinces.get(position).getName());
        viewHolder.arrow.setImageResource(provinces.get(position).getImage());
        return convertView;
    }

