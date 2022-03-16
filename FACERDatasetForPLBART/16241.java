    @Override
    public void onBindViewHolder(OptionHolder holder, final int position) {
        HashMap<String, Object> map = datas.get(position);
        String option = (String) map.get("option");
        int icon = (int) map.get("icon");
        holder.ivIcon.setImageResource(icon);
        holder.tvOption.setText(option);
        final int mPosition = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onItemClickListener)
                    onItemClickListener.itemClick(mPosition);
            }
        });
    }

