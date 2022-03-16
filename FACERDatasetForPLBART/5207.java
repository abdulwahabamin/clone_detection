    @Override
    public void onBindViewHolder(MediaViewHolder holder, int position) {
        if(onRecyclerItemClickListener!=null){
            holder.constraintLayout.setOnClickListener(view -> {
                if(holder.constraintLayout.getRotation()==SELECTED_ROTATION){
                    holder.constraintLayout.setRotation(0);
                    selectedList.remove(fileDirectoryList.get(position));
                    onItemSelectedListener.onItemListChanged(selectedList);
                }
                else if(selectedList.size()>0){
                    selectedList.add(fileDirectoryList.get(position));
                    holder.constraintLayout.setRotation(SELECTED_ROTATION);
                    onItemSelectedListener.onItemListChanged(selectedList);
                }
                else
                    onRecyclerItemClickListener.onClick(view,position);
            });
        }


        if(selectedList.size()>0 && selectedList.contains(fileDirectoryList.get(position))){
            holder.constraintLayout.setRotation(SELECTED_ROTATION);

        }else{
            holder.constraintLayout.setRotation(0);

        }
        holder.constraintLayout.setOnLongClickListener(view -> {
            if(!selectedList.contains(fileDirectoryList.get(position))) {
                selectedList.add(fileDirectoryList.get(position));
                holder.constraintLayout.setRotation(SELECTED_ROTATION);
                onItemSelectedListener.onItemListChanged(selectedList);
            }
            return true;
        });
        int width=(int)context.getResources().getDimension(R.dimen.media_view_width);
        int height=(int)context.getResources().getDimension(R.dimen.media_view_width);
        try {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            params.setMargins(10,10,10,10);
            params.gravity= Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL;

            LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            nameParams.setMargins(6,6,6,6);
            nameParams.gravity=Gravity.CENTER_HORIZONTAL;

            switch (type) {
                case QuickAccess.IMAGES:

                    glide.load(new File(fileDirectoryList.get(position).getPath()))
                         .apply(AppController.getRequestOptions())
                         .transition(GenericTransitionOptions.with(R.anim.item_fall_down))
                         .into(holder.thumbnail);
                    holder.name.setVisibility(View.GONE);

                    break;

                case QuickAccess.AUDIO:
                    holder.name.setText(Util.getTrimmed(fileDirectoryList.get(position).getName()));
                    holder.name.setTextSize(15);
                    holder.thumbnail.setLayoutParams(params);
                    if(!isImageSet(holder.thumbnail,R.drawable.file))
                        loadThumbnail(holder,position,Util.MUSIC_ART);
                    break;

                case QuickAccess.VIDEO:
                    holder.name.setText(Util.getTrimmed(fileDirectoryList.get(position).getName()));
                    holder.name.setTextSize(15);
                    holder.thumbnail.setLayoutParams(params);
                    if(!isImageSet(holder.thumbnail,R.drawable.file))
                        loadThumbnail(holder,position,Util.VIDEO_ART);
                    break;

                case QuickAccess.DOCUMENTS:
                    holder.thumbnail.setImageResource(Util.getImageResIdFromExension(fileDirectoryList.get(position).getName()));
                    holder.name.setTextSize(15);
                    holder.name.setText(Util.getTrimmed(fileDirectoryList.get(position).getName()));
                    holder.thumbnail.setLayoutParams(params);
                    break;

            }
        }catch (Exception e){
            Log.e(TAG,"glide error: "+e.getMessage());
            //e.printStackTrace();

        }
    }

