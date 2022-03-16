        /**
         * Return the view as a document
         *
         * @return StringBuilder a buffer to the document
         */
        public StringBuilder toStringDocument() {
            StringBuilder sb = new StringBuilder();
            int c = getCount();
            for (int i = 0; i < c; i++) {
                sb.append(getItem(i));
                sb.append("\n");
            }
            return sb;
        }

