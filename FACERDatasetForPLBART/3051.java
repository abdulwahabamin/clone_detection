    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FileView file = files.get(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView tile = (ImageView) view.findViewById(R.id.image_view);
        TextView name = (TextView) view.findViewById(R.id.file_name);
        tile.setImageBitmap(file.tile);
        name.setText(file.name);
        return view;
    }

