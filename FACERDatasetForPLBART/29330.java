         ViewHolder(View itemView){
            super(itemView);
            view=itemView;
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            Button mButton=(Button)view.findViewById(R.id.button_delete_city);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onDeleteButtonClick(v,getAdapterPosition());
                }
            });
        }

