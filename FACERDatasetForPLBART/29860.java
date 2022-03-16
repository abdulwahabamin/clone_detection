        void setUpOnClick(View parent) {
            (parent.findViewById(R.id.credits)).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(context.getString(R.string.dev_2_link)));
                            context.startActivity(intent);
                        }
                    }
            );
        }

