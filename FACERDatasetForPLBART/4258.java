    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        //view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        //LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.file_explore_list_item, null);
            //convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.explore_item_head);
            holder.selectBox = (ImageView) view.findViewById(R.id.explore_file_type);
            holder.data = (TextView) view.findViewById(R.id.explore_item_size);
            holder.date = (TextView) view.findViewById(R.id.explore_item_date);
            holder.check=(ImageView) view.findViewById(R.id.file_explore_check);
            view.setTag(holder);

        }

        holder = (ViewHolder) view.getTag();
        // put the image on the text view
        IndexerFile iitem= Searcher.get(position);
        FileItem item = iitem.getAsFileItem();

        holder.check.setVisibility(View.VISIBLE);
        if(item.getAbsoluteFile().isDirectory())
            holder.check.setVisibility(View.GONE);

        //holder.title.setCompoundDrawablesWithIntrinsicBounds(item.icon, 0, 0, 0);
        holder.title.setText(item.file);
        //holder.selectBox.setTag(chkhold);
        String size = Num.btyesToFileSizeString(item.length());
        if(item.PARENT_TYPE_==FileItem.PARENT_TYPE_ZIP)
            size=Num.btyesToFileSizeString(item.zipFileSize);
        holder.data.setText(size);
        holder.date.setText(Cal.getCal(item.lastModified()).getDatabaseDate());

        holder.selectBox.setVisibility(View.VISIBLE);


        if(item.exists() && Files.isImage(item.getName())) {
            ImageCache.CacheBitmap cb = ImageCache.get(item.getPath());
            if(cb!=null) {
                holder.selectBox.setImageBitmap(cb.bitmap);
            } else {
                LoadImageTask loadImage = new LoadImageTask();
                loadImage.setData(item,position,holder.selectBox);
                loadImage.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
                holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
            }

        } else {
            holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
        }

        ImageView showInfo = (ImageView) view.findViewById(R.id.file_info);
        InfoClicker info = new InfoClicker(activity,item);
        //info.pos=position;
        showInfo.setOnClickListener(info);

        return view;
    }

