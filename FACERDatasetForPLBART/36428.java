        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mFilterData = (List<City>) filterResults.values;
            if (filterResults.count > 0) {
                notifyDataSetChanged();//�?绘当�?�?��?区域
            } else {
                mFilterData = cities;
                notifyDataSetChanged();//会�?绘控件（还原到�?始状�?）
            }
        }

