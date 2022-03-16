        public View getView(int position, View convertView, ViewGroup parent) {
            View view=convertView;

            if(view==null) {
                view = inflater.inflate(R.layout.navigation_drawer_item,parent,false);

            }


            TextView text=(TextView) view.findViewById(R.id.btn_nav_item_txt);
            ImageView img = (ImageView) view.findViewById(R.id.btn_nav_item_img);

            Holder it = items.get(position);
            if(it!=null) {
                text.setText(it.txt);
                img.setImageDrawable(activity.getResources().getDrawable(it.Rid));

                text.bringToFront();
            }

            return view;


        }

