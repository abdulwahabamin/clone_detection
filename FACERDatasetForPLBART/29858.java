        void setUpOnClick(View parent) {
            (parent.findViewById(R.id.more_apps)).setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(context.getString(R.string.other_apps_link)));
                            context.startActivity(intent);
                        }
                    }
            );
            (parent.findViewById(R.id.name)).setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(context.getString(R.string.github_link)));
                            context.startActivity(intent);
                        }
                    }
            );
        }

