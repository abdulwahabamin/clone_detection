        void setUpOnClick(View parent) {
            parent.findViewById(R.id.insp_1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(context.getString(R.string.insp_1_link)));
                    context.startActivity(intent);
                }
            });
            parent.findViewById(R.id.insp_2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(context.getString(R.string.insp_2_link)));
                    context.startActivity(intent);
                }
            });
            parent.findViewById(R.id.insp_3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(context.getString(R.string.insp_3_link)));
                    context.startActivity(intent);
                }
            });
        }

