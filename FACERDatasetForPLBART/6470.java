        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Context context = parent.getContext();

            if (convertView == null) {
                final LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.item_doc_list, parent, false);
            }

            final ImageView iconMime = (ImageView) convertView.findViewById(R.id.icon_mime);
            final TextView title = (TextView) convertView.findViewById(android.R.id.title);
            final View line2 = convertView.findViewById(R.id.line2);

            final DocumentStack stack = getItem(position);
            iconMime.setImageDrawable(stack.root.loadIcon(context));

            final Drawable crumb = context.getResources()
                    .getDrawable(R.drawable.ic_breadcrumb_arrow);
            crumb.setBounds(0, 0, crumb.getIntrinsicWidth(), crumb.getIntrinsicHeight());

            final SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append(stack.root.title);
            for (int i = stack.size() - 2; i >= 0; i--) {
                appendDrawable(builder, crumb);
                builder.append(stack.get(i).displayName);
            }
            title.setText(builder);
            title.setEllipsize(TruncateAt.MIDDLE);

            if (line2 != null) line2.setVisibility(View.GONE);

            return convertView;
        }

