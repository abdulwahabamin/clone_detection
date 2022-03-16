        @Override
        public void drop(int from, int to) {
            if (from!=to) {
                String item = adapter.getItem(from);
                adapter.remove(item);
                adapter.insert(item, to);
                
            }
            
        }

