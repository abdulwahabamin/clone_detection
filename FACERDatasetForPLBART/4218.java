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



        //TextView textView = (TextView) view.findViewById(R.id.explore_item_head);
        //ImageView img = (ImageView) view.findViewById(R.id.explore_file_type);

        // put the image on the text view
        IndexerFile iitem= Searcher.get(position);
        FileItem item = iitem.getAsFileItem();
        //CheckHolder chkhold= new CheckHolder();
        //chkhold.position= Integer.valueOf(position);
        //chkhold.check=holder.check;
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
        //if(item.icon==Files.F_DIR) {
        //	holder.selectBox.setVisibility(View.GONE);
        //} else {
        holder.selectBox.setVisibility(View.VISIBLE);
        //holder.selectBox.setClickable(true);




        //holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));

        //if(item.file.endsWith(".jpg")) {
        //	holder.selectBox.setImageDrawable(item);
        //} else {
        holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
        // }

        //view.setBackgroundColor(activity.getResources().getColor(R.color.white));

        return view;
    }

