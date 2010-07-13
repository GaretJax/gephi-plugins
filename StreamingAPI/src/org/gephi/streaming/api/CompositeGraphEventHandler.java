/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.streaming.api;

import java.util.ArrayList;
import java.util.List;
import org.gephi.streaming.api.event.GraphEvent;

/**
 * A simple GraphEventHandler implementation that is able to
 * loop through a list of GraphEventHandler and delegate the events
 * to them.
 * 
 * @author Andre' Panisson
 *
 */
public class CompositeGraphEventHandler implements GraphEventHandler {
    
    private List<GraphEventHandler> handlers = new ArrayList<GraphEventHandler>();
    
    /**
     * Add an GraphEventHandler to the list of OperationSupports to delegate the events.
     * 
     * @param handler the GraphEventHandler to add
     */
    public void addHandler(GraphEventHandler handler) {
        handlers.add(handler);
    }
    
    /**
     * Remove an GraphEventHandler from the list of OperationSupports
     * 
     * @param handler the GraphEventHandler to remove
     */
    public void removeHandler(GraphEventHandler handler) {
        handlers.remove(handler);
    }

    @Override
    public void handleGraphEvent(GraphEvent event) {
        for (GraphEventHandler handler: handlers) {
            handler.handleGraphEvent(event);
        }
    }

}
