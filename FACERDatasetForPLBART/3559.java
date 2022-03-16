        /**
         * Sets up the given animation to play at the same time as the animation supplied in the
         * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object.
         *
         * @param anim The animation that will play when the animation supplied to the
         * {@link AnimatorSet#play(Animator)} method starts.
         */
        public Builder with(Animator anim) {
            Node node = mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(mCurrentNode, Dependency.WITH);
            node.addDependency(dependency);
            return this;
        }

