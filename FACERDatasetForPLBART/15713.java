        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getFormattedLength());
            holder.mContentView.setText(mValues.get(position).name);
            holder.albumArt.setImageBitmap(mValues.get(position).albumArt);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

