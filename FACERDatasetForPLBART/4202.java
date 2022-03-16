        public LastFilesAdapter(Activity c, GridView parent, List<IndexerFile> items) {
            this.activity = c;
            this.parent=parent;
            this.items=items;


            imgWidth=Functions.dpToPx(120,c);
            imgHeight=Functions.dpToPx(90,c);
            txtItemPadTop = Functions.dpToPx(70,c);

            param = new AbsListView.LayoutParams(imgWidth,imgHeight);
            txtparams = new AbsListView.LayoutParams(imgWidth,Functions.dpToPx(20,c));
            txtppod = new AbsListView.LayoutParams(imgWidth,imgHeight);

            //laycheck = new RelativeLayout.LayoutParams(65,60);
            //laycheck.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            //laycheck.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        }

