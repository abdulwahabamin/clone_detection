        @Override
        public View getView(int position, View converttvView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View v=inflater.inflate(R.layout.cust_list, parent, false);
            TextView tv1=(TextView)v.findViewById(R.id.textView);
            TextView tv2=(TextView)v.findViewById(R.id.textView2);
            tv1.setText(al1.get(position));
            tv2.setText(al2.get(position));
            return v;
        }

