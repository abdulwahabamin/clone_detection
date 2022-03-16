    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.message_layout,null);
        }
        ViewHolder vh= new ViewHolder();
        vh.receiveText=(TextView)convertView.findViewById(R.id.textBoxReceived);
        vh.sendText=(TextView)convertView.findViewById(R.id.mtextBox);


        return super.getView(position, convertView, parent);
    }

