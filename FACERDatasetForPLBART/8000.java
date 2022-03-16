        @Override
        public void onClick(View itemView) {
            MainActivity context = (MainActivity) itemView.getContext();
            int position = getAdapterPosition();

            if (getFile(position).isDirectory()) {
                context.setCurrentDirectory(position);
            }
        }

