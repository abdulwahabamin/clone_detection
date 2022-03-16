        /**
         * Sets up the given animation to play when the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
         * to start when the animation supplied in this method call ends.
         *
         * @param anim The animation whose end will cause the animation supplied to the
         * {@link AnimatorSet#play(Animator)} method to play.
         */
        public Builder after(Animator anim) {
            Node node = mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(node, Dependency.AFTER);
            mCurrentNode.addDependency(dependency);
            return this;
        }

