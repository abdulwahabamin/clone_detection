    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinkObject linky = listOfLinks.get(position);
        //Toast.makeText(context, linky.getImagelink(), Toast.LENGTH_SHORT).show();
        Glide.with(context).load(linky.getImagelink()).into(holder.myImageView);
 
    }

