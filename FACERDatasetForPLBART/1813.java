        public MyViewVolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.text1);
            last_message = (TextView) itemView.findViewById(R.id.text2);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

