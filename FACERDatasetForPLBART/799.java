    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ChatModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        int type = dataModel.getType();

        if (convertView == null) {

            viewHolder = new ViewHolder();

            if(type == 0){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.list_item_for_sender_message, parent, false);
                viewHolder.tvMessage = (TextView) convertView.findViewById(R.id.tvMessage);

            }else if(type == 1){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.list_item_for_receiver_message, parent, false);
                viewHolder.tvMessage = (TextView) convertView.findViewById(R.id.tvMessage);

            }

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.tvMessage.setText(""+dataModel.getMessage());
        return convertView;
    }

