    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.available_group, parent, false);
        }

        ShareGroup.GlidePlayerGroup group = groups.get(position);
        if(group != null) {
            TextView textView = (TextView)v.findViewById(R.id.group_name);
            textView.setText(group.groupName);
            textView = (TextView)v.findViewById(R.id.owner);
            textView.setText(group.owner.name);
            textView = (TextView)v.findViewById(R.id.device_name);
            textView.setText(group.owner.deviceName);
            textView = (TextView)v.findViewById(R.id.no_of_members);
            textView.setText(String.valueOf(group.getMemberCount()));
        }
        return v;
    }

