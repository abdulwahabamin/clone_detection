    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_ble, null, false);
            holder.tvName = convertView.findViewById(R.id.tvBle);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tvName.setText(list.get(position).getUuid().toString());

        return convertView;
    }

