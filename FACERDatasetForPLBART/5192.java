    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
        holder.name.setText(Util.getTrimmed(fileDirectories.get(position).getName()));
        holder.info.setText(fileDirectories.get(position).getDate());
        if(selectedList.size()>0 && selectedList.contains(fileDirectories.get(position))){
            holder.mainView.setBackground(new ColorDrawable(Color.parseColor(selectedColor)));
        }else{
            holder.mainView.setBackground(new ColorDrawable(Color.WHITE));
        }

        // when user long clicks on any list item add it to selection list and notify activity.
        holder.mainView.setOnLongClickListener((view)->{
                selectedList.add(fileDirectories.get(position));
                onItemSelectedListener.onItemListChanged(selectedList);
                holder.mainView.setBackground(new ColorDrawable(Color.parseColor(selectedColor)));
            return true;
        });

        // on clicking item
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable=(ColorDrawable) holder.mainView.getBackground();

                try {
                    if(colorDrawable!=null) {

                        // Checking whether the clicked item is present in selected list.
                        // Remove if yes
                        if (colorDrawable.getColor() == Color.parseColor(selectedColor) && !isCopied) {
                            selectedList.remove(fileDirectories.get(position));
                            onItemSelectedListener.onItemListChanged(selectedList);
                            holder.mainView.setBackground(null);
                            return;
                        }
                    }

                    // If selection mode is enabled add item to list notify the activity.
                    if(!isCopied &&  selectedList.size()>0){

                        selectedList.add(fileDirectories.get(position));
                        onItemSelectedListener.onItemListChanged(selectedList);
                        holder.mainView.setBackground(new ColorDrawable(Color.parseColor(selectedColor)));
                        return;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                // if clicked item is a directory or folder open it and list files.
                if(fileDirectories.get(position).getFileOrDir()== FileDirectory.DIR){
                    fileEx.openDir(fileDirectories.get(position).getName());
                    loadFiles();
                    // call back when opening new dir to update breadcrumbs
                    onAdpaterDirectoryChangeListener.onDirectoryChange(fileDirectories);
                    notifyDataSetChanged();
                }

                // if its a file then open it.
                else{
                    Intent i=fileEx.getOpenableIntent(fileDirectories.get(position).getName());
                    if(i!=null)
                        context.startActivity(i);
                    else
                        Toast.makeText(context.getApplicationContext(),context
                                .getResources()
                                .getString(com.singh.multimeet.quicxplo.R.string.no_app_available),Toast.LENGTH_SHORT).show();
                }
            }
        });

        String name=fileDirectories.get(position).getName();

        // getting tye of file to be opened.
        String ext=MimeTypeMap.getFileExtensionFromUrl(name);
        if(fileDirectories.get(position).getFileOrDir()== FileDirectory.DIR){
            holder.size.setText("");
            holder.icon.setImageResource(com.singh.multimeet.quicxplo.R.drawable.folder);
            return;
        }

        // If current item is an image.
        else if(ext.length() <= 3 && (ext.equals(IMG_TYPES[0]) || ext.equals(IMG_TYPES[1])
                || ext.equals(IMG_TYPES[2]))){
            holder.size.setText(fileDirectories.get(position).getSize());
            Glide.with(context).load(Uri.fromFile(new File(fileDirectories
                    .get(position).getPath()))).apply(AppController.getRequestOptions())
                    .transition(GenericTransitionOptions.with(com.singh.multimeet.quicxplo.R.anim.item_fall_down))
                    .into(holder.icon);
        }


        // If current item is not a directory.
        else {
            holder.size.setText(fileDirectories.get(position).getSize());
            holder.icon.setImageResource(Util.getImageResIdFromExension(fileDirectories
                    .get(position).getName()));
        }

    }

