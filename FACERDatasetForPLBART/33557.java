    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PreferenceViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.row_app_theme_preference_list,
                    parent, false);
            holder = new PreferenceViewHolder();

            holder.colorView = rowView.findViewById(R.id.app_theme_color);
            holder.nameTextView = (CheckedTextView) rowView.findViewById(R.id.app_theme_name);
            rowView.setTag(holder);
        }

        holder = (PreferenceViewHolder) rowView.getTag();

        GradientDrawable gradientDrawable = (GradientDrawable) holder.colorView.getBackground();
        gradientDrawable.setColor(resourceIds[position]);

        holder.nameTextView.setText(getItem(position));
        holder.nameTextView.setChecked(position == index);
        return rowView;
    }

