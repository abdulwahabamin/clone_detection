        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            content = (TextView) itemView.findViewById(R.id.content);
            time = (TextView) itemView.findViewById(R.id.time);
            image = (ImageView) itemView.findViewById(R.id.picture);
            Log.i("Steps","MyViewHolderConstructor");
        }

