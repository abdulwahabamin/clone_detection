    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.songTitle.setText(songs.get(position).getSongTitle());
        holder.songDuration.setText(TimeFormatUtils.secondsToTimer(songs.get(position).getSongDuration()));

        ObjectAnimator animX;
        if (isSelected(position)) {
            animX = ObjectAnimator.ofFloat(holder.rowView, "x", 150f);
        } else {
            animX = ObjectAnimator.ofFloat(holder.rowView, "x", 0f);
        }
        animX.setDuration(250);
        animX.start();
    }

