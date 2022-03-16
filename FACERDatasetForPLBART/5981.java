    @Override
    public void onBindViewHolder(final VideoAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).getName());
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        try {
            media.setDataSource(mDatas.get(position).getAbsolutePath());
        }catch (Exception e){
            Log.d("aaa", "onBindViewHolder: " + "有了");
        }
        Bitmap bitmap = media.getFrameAtTime();
        holder.icon.setImageBitmap(bitmap);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.mLayout, pos);

                    String path = mDatas.get(pos).getPath();
                    Intent intent = FileUtil.openFile(path);
                    mContext.startActivity(intent);
                }
            });

            holder.mLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.mLayout, pos);
                    final String items[] = {"�?命�??文件", "文件详情", "分享"};
                    
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);  //先得到构造器  
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();  
                            if (which == 0) {
                                ReName(holder.getAdapterPosition());
                            } else if (which == 1)
                                ShowDetial(holder.getAdapterPosition());
                            else if (which == 2) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("video/*");
                                Uri uri = Uri.fromFile(mDatas.get(holder.getAdapterPosition()));
                                intent.putExtra(Intent.EXTRA_STREAM, uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                mContext.startActivity(Intent.createChooser(intent, "分享到"));
                            }
                        }
                    });
                    builder.create().show();
                    return false;
                }
            });


            holder.file_video_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    mOnItemClickLitener.onItemClick(holder.tv, pos);
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("确认删除");
                    builder.setMessage("是�?�确认删除该文件");
                    builder.setNegativeButton("�?�消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            removeData(holder.getAdapterPosition());
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    synchronized (this) {
                        this.notify();
                    }
                }
            });
        }
    }

