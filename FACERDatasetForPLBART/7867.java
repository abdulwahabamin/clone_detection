        public View getView( int position, View convertView, ViewGroup parent ) {
            try {
                ToolButton tb = array.get( position );
                if( tb != null ) {
                    View row = convertView;
                    ViewHolder holder = null;
                    if( row == null ) {                                                    
                        LayoutInflater inflater = getLayoutInflater();
                        row = inflater.inflate( R.layout.butrow, parent, false ); // null ?
                        final ViewHolder viewHolder$ = new ViewHolder();
                        viewHolder$.tb = tb;
                        viewHolder$.label = (TextView)row.findViewById( R.id.tb_label );
                        viewHolder$.caped = (EditText)row.findViewById( R.id.tb_caption );
                        viewHolder$.caped.addTextChangedListener( new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                }
                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {
                                }
                                @Override
                                public void afterTextChanged( Editable e ) {
                                    viewHolder$.tb.setCaption( viewHolder$.caped.getText().toString() );
                                }
                            });
                        viewHolder$.viscb = (CheckBox)row.findViewById( R.id.tb_visible );
                        viewHolder$.viscb.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged( CompoundButton buttonView, boolean isChecked) {
                                    viewHolder$.tb.setVisible( buttonView.isChecked() );
                                }
                            });
                        row.setTag( viewHolder$ );
                        holder = viewHolder$;
                    }
                    else {
                        holder = (ViewHolder)row.getTag();
                        holder.tb = tb;
                    }
                    holder.label.setText( tb.getName( ToolButtonsProps.this ) );
                    holder.viscb.setChecked( tb.isVisible() );
                    holder.caped.setText( tb.getCaption() );
                    return row;
                }
            } catch( Exception e ) {
                Log.e( TAG, "position " + position, e );
            }
            return null;
        }

