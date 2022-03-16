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

        BluetoothDevice device = list.get(position);

        if (device.getName() == null) {
            holder.tvName.setText(device.getAddress());
        } else {
            holder.tvName.setText(device.getName() + ":" + device.getAddress());

        }


        return convertView;
    }

