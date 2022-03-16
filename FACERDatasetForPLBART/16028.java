        @Override
        public int getItemPosition(Object object) {
            if(object == toReplace) {
                toReplace = null;
                return POSITION_NONE;
            } else {
                return POSITION_UNCHANGED;
            }
        }

