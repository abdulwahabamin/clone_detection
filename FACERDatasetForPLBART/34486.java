        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            CityHolder holder ;
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.search_result_item,null);
                holder = new CityHolder();
                holder.searchResultItem = (TextView) convertView.findViewById(R.id.search_result_item);
                convertView.setTag(holder);
            }
            holder = (CityHolder) convertView.getTag();

            holder.searchResultItem.setText(result.get(position).cityName + "(" + result.get(position).prov +")" );
            return convertView;
        }

