    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View thisView = convertView;

        if (thisView == null) {
            LayoutInflater inflater = (LayoutInflater.from(activityContext));
            thisView = inflater.inflate(idViewResource, null);
        }
        ImageView imageView = (ImageView) thisView.findViewById(R.id.imageView);
        TextView nameView = (TextView) thisView.findViewById(R.id.name_text_view);
        File file = getItem(position);

        /* Controllo se l'elemento è una directory oppure un file, cambiando l'icona */
        if (file.isDirectory()) {
            imageView.setImageResource(R.drawable.ic_folder_black);
        } else {
            imageView.setImageResource(R.drawable.ic_insert_drive_file_black);
        }

        nameView.setText(file.getName());
        return thisView;
    }

