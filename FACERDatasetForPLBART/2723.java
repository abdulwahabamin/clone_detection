    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.file_row, parent, false);
        }

        TextView fileText = (TextView) convertView.findViewById(R.id.fileText);
        ImageView fileIcon = (ImageView) convertView.findViewById(R.id.fileIcon);
        TextView fileSize = (TextView) convertView.findViewById(R.id.fileSize);

        File f = files.get(position);
        fileText.setText(f.getName());

        if (f.isFile()) {
            fileIcon.setImageResource(R.drawable.file_icon);
            fileSize.setText(Formatter.formatShortFileSize(context, f.length()));
        } else {
            fileIcon.setImageResource(R.drawable.folder_icon);
            fileSize.setText("");
        }

        return convertView;
    }

