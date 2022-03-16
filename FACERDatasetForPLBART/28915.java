        /**
         * @see IProcessHttpRequest#processFailScenario(VolleyError)
         */
        @Override
        public void processFailScenario(final VolleyError error) {
            Handler h = new Handler(this.context.getMainLooper());
            h.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, context.getResources().getString(R.string.error_radius_search), Toast.LENGTH_LONG).show();
                }
            });
        }

