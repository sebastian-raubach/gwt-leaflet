/*
 *  Copyright 2018 Sebastian Raubach from the Information
 *  and Computational Sciences Group at JHI Dundee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jhi.gwt.leaflet.client.basic;

import com.google.gwt.core.client.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletLatLngBounds extends JavaScriptObject
{
	protected LeafletLatLngBounds()
	{
	}

	public static LeafletLatLngBounds newInstance(LeafletLatLng topLeft, LeafletLatLng bottomRight)
	{
		return createJso(topLeft, bottomRight).cast();
	}

	private static native JavaScriptObject createJso(LeafletLatLng topLeft, LeafletLatLng bottomRight) /*-{
		return $wnd.L.latLngBounds(topLeft, bottomRight);
	}-*/;

	public final native LeafletLatLngBounds pad(double padding)/*-{
		this.pad(padding);
		return this;
	}-*/;

	public final native LeafletLatLngBounds extend(LeafletLatLng point)/*-{
		this.extend(point);
		return this;
	}-*/;
}
