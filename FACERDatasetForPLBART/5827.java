        @Override
        protected Integer doInBackground(Object... params) {
            File f= (File) params[0];
            String destination = (String) params[1];
            boolean result = extract(f, destination);
            return result ? success : error;
        }

