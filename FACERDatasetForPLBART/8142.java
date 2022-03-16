        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final Context context = getContext();
                LayoutInflater inflater = LayoutInflater.from(context);
                Theme theme = ThemeManager.getCurrentTheme(context);

                v = inflater.inflate(R.layout.hexdump_line, parent, false);
                ViewHolder viewHolder = new EditorActivity.HexDumpAdapter.ViewHolder();
                viewHolder.mTextView = (TextView)v.findViewById(android.R.id.text1);

                viewHolder.mTextView.setTextAppearance(context, R.style.hexeditor_text_appearance);
                viewHolder.mTextView.setTypeface(mHexTypeface);
                theme.setTextColor(context, viewHolder.mTextView, "text_color"); //$NON-NLS-1$

                v.setTag(viewHolder);
            }

            String text = getItem(position);
            ViewHolder viewHolder = (ViewHolder)v.getTag();
            viewHolder.mTextView.setText(text);

            return v;
        }

