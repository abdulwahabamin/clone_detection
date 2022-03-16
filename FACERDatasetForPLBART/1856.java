    @Override
    public void onBindViewHolder(SearchAdapter.MyViewHolder holder, int position) {
        holder.text.setText(devices.get(position).getName());
        if (states.get(position)) {
            state= android.R.drawable.presence_online;
        }else
        {
            state= android.R.drawable.presence_invisible;
        }
        holder.text.setCompoundDrawablesWithIntrinsicBounds(0, 0, state,0);

    }

