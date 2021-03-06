/*
 * Copyright 2012 Eike Kettner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eknet.neoswing;

import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.Graph;

/**
 * @author <a href="mailto:eike.kettner@gmail.com">Eike Kettner</a>
 * @since 14.05.11 13:11
 */
public enum Layouts implements LayoutFactory {

  SpringLayout {
    @Override
    public <V,E> AbstractLayout<V, E> createLayout(Graph<V, E> graoh) {
      return new SpringLayout2<V, E>(graoh);
    }
  },

  FRLayout {
    @Override
    public <V,E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new FRLayout2<V, E>(graph);
    }
  },

  CircleLayout {
    @Override
    public <V,E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new CircleLayout<V, E>(graph);
    }
  },

  DAGLayout {
    @Override
    public <V, E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new DAGLayout<V, E>(graph);
    }
  },

  ISOMLayout {
    @Override
    public <V, E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new ISOMLayout<V, E>(graph);
    }
  },

  KKLayout {
    @Override
    public <V, E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new KKLayout<V, E>(graph);
    }
  },

  RandomLayout {
    @Override
    public <V, E> AbstractLayout<V, E> createLayout(Graph<V, E> graph) {
      return new StaticLayout<V, E>(graph);
    }
  }

}
