        ViewHolder(final View view, NavigationItemClickListener listener) {
            super(view);
            navListener = listener;
            textView = view.findViewById(R.id.path_navigation);
            textView.setOnClickListener(this);
        }

