        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (position < mCursorCount) {
                return getDocumentView(position, convertView, parent);
            } else {
                position -= mCursorCount;
                convertView = mFooters.get(position).getView(convertView, parent);
                // Only the view itself is disabled; contents inside shouldn't
                // be dimmed.
                convertView.setEnabled(false);
                return convertView;
            }
        }

