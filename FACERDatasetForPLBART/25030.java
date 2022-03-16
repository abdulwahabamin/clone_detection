        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClicked(getAdapterPosition());
            }
        }

