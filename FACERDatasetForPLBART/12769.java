        @Override
        protected Throwable doInBackground(Object... params) {
            try {
                this.mCallable.doInBackground(params);

                // Success
                return null;

            } catch (Throwable ex) {
                // Capture the exception
                return ex;
            }
        }

