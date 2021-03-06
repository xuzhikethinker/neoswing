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

package org.eknet.neoswing.view.control;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import org.eknet.neoswing.ElementId;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author <a href="mailto:eike.kettner@gmail.com">Eike Kettner</a>
 * @since 11.01.12 21:15
 */
public class SelectElementMousePlugin extends AbstractMousePlugin {

  public static final String PROPERTY_ELEMENT = "selectedElement";

  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private ElementId<?> selected;

  public SelectElementMousePlugin(int button) {
    super(button);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  @Override
  public boolean checkModifiers(MouseEvent e) {
    return e.getButton() == modifiers;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (checkModifiers(e)) {
      VisualizationViewer<Vertex, Edge> viewer = getViewer(e);
      down = e.getPoint();
      Vertex node = viewer.getPickSupport().getVertex(viewer.getGraphLayout(), down.getX(), down.getY());
      if (node != null) {
        propertyChangeSupport.firePropertyChange(PROPERTY_ELEMENT, this.selected, ElementId.vertexId(node));
        this.selected = ElementId.vertexId(node);
      }
      Edge relationship = viewer.getPickSupport().getEdge(viewer.getGraphLayout(), down.getX(), down.getY());
      if (relationship != null) {
        propertyChangeSupport.firePropertyChange(PROPERTY_ELEMENT, this.selected, ElementId.edgeId(relationship));
        this.selected = ElementId.edgeId(relationship);
      }
    }
  }
}
