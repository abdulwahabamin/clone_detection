        @Override
        public void onClick(View view){

            int itemPosition = getAdapterPosition();

            Intent intent = new Intent(nContext,MusicPlayerActivity.class);
            intent.putExtra("audio",audioList.get(itemPosition));

            nContext.startActivity(intent);

        }

