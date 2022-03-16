    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        File file=filedata.get(position);
        fileItemListener=new FileListItemListener();
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.file_item,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(file.isDirectory()){
            viewHolder.fileImage.setImageResource(R.mipmap.folder);
            viewHolder.fileContent.setText(String.valueOf(file.listFiles().length));
        }else {
            viewHolder.fileImage.setImageResource(R.mipmap.file);
        }
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        viewHolder.fileName.setText(file.getName());
        viewHolder.fileTime.setText(format.format(new Date(file.lastModified())));
        return convertView;
    }

