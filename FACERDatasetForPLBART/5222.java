    @Override
    public void onBindViewHolder(RecentFileViewHolder holder, int position) {
        holder.main.setOnClickListener((view)->{
            if(onRecyclerItemClickListener!=null){
                onRecyclerItemClickListener.onClick(view,position);
            }
        });

        holder.main.setOnLongClickListener(view -> {
            if(onRecyclerItemClickListener!=null)
                onRecyclerItemClickListener.onLongClick(view,position);
            return true;
        });

        String parentDir=Util.getParentDirName(new File(totalList.get(position)
                .getPath()).getParent());

        // getting time difference from today.
        holder.date.setText(getTimeDifference(Util.getDateFromPath(totalList.get(position)
                .getPath() ),calendar.getTime()));

        String image=totalList.get(position).getName();
        if(parentDir.equalsIgnoreCase(".Statuses")) {
            holder.folder.setText(String.format("from %s","WhatsApp"));
            holder.name.setText("WhatsApp Story");
        }
        else {
            holder.folder.setText(String.format("from %s",parentDir));
            holder.name.setText(Util.getTrimmed(totalList.get(position).getName()));
        }
        holder.size.setText(totalList.get(position).getSize());

        if(isImage(image)){
            imgParams.setMargins(0,0,10,0);
            imgParams.addRule(RelativeLayout.CENTER_VERTICAL);
            holder.icon.setLayoutParams(imgParams);
            requestManager.load(totalList.get(position).getPath())
                    .apply(AppController.getRequestOptions())
                    .thumbnail(0.7f)
                    .into(holder.icon);
            if(holder.icon.getDrawable()==null){
                totalList.remove(position);
                notifyItemRemoved(position);
            }
        }
        else if(Util.getImageResIdFromExension(totalList.get(position).getName())==R.drawable.video){
            loadThumbnail(holder,position,Util.VIDEO_ART);
        }

        else{

            holder.icon.setImageResource(Util.getImageResIdFromExension(totalList
                    .get(position).getName()));
        }
    }

