        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mFilterData = (List<City>) filterResults.values;
            if (filterResults.count > 0) {
                notifyDataSetChanged();//é‡?ç»˜å½“å‰?å?¯è§?åŒºåŸŸ
            } else {
                mFilterData = cities;
                notifyDataSetChanged();//ä¼šé‡?ç»˜æŽ§ä»¶ï¼ˆè¿˜åŽŸåˆ°åˆ?å§‹çŠ¶æ€?ï¼‰
            }
        }

