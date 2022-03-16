    @Override
    public void onBindViewHolder(FileViewHolder holder, int position) {
        holder.name.setText(Util.getTrimmed(fileDirectoryList.get(position).getName()));
        holder.info.setText(fileDirectoryList.get(position).getDate());
        String ext=MimeTypeMap.getFileExtensionFromUrl(fileDirectoryList.get(position).getName());
        holder.mainView.setOnClickListener(view ->{
            if(onRecyclerItemClickListener!=null){
                onRecyclerItemClickListener.onClick(view,position);
            }
        } );

        holder.mainView.setOnLongClickListener(view -> {
            if(onRecyclerItemClickListener!=null)
                onRecyclerItemClickListener.onLongClick(view,position);
            return true;
        });
        if(fileDirectoryList.get(position).getFileOrDir()== FileDirectory.DIR){
            holder.size.setText("");
            holder.icon.setImageResource(R.drawable.folder);
            return;
        }
        else if(ext.length()<=3 && (ext.equals(IMG_TYPES[0]) || ext.equals(IMG_TYPES[1])
                || ext.equals(IMG_TYPES[2]))){
            holder.size.setText(fileDirectoryList.get(position).getSize());
            Glide.with(context).load(Uri.fromFile(new File(fileDirectoryList
                    .get(position).getPath()))).into(holder.icon);
        }
        else {
            holder.size.setText(fileDirectoryList.get(position).getSize());
            holder.icon.setImageResource(Util.getImageResIdFromExension(fileDirectoryList
                    .get(position).getName()));
        }
    }

