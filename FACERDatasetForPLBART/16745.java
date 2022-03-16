        MyViewHolder(View view) {
            super(view);
            mainLayout = (ConstraintLayout) view.findViewById(R.id.mainLayout);
            albumArt = (ImageView) view.findViewById(R.id.albumArt);
            title = (TextView) view.findViewById(R.id.title);
            detail = (TextView) view.findViewById(R.id.detail);
            popupMenuBtn = (ImageButton) view.findViewById(R.id.popupMenuBtn);
            sectionHeader = (TextView) view.findViewById(android.R.id.text1);
        }

