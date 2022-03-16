	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_list_item, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.file);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		File current = new File(values.get(position));
		textView.setText(current.getName());
		// Change the icon for files and folders
		if (current.isDirectory()) {
			imageView.setImageResource(R.drawable.folder);
		} else {
			imageView.setImageResource(R.drawable.file);
		}
		if (isPositionChecked(position))
			rowView.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
		return rowView;
	}

