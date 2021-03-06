/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2012 Dimitry
 *
 *  This file author is Dimitry
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.freeplane.features.text;

import java.awt.Color;

/**
 * @author Dimitry Polivaev
 * 04.05.2012
 */
public class HighlightedTransformedObject {

	final private Object object;
	public static final Color OK_COLOR = Color.GREEN;
	public static final Color FAILURE_COLOR = Color.RED;
	public Object getObject() {
    	return object;
    }

	public HighlightedTransformedObject(Object object) {
	    this.object = object;
    }
	
	@Override
    public String toString() {
	    return object.toString();
    }
	
	
}
