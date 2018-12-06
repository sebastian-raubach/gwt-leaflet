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

import jhi.gwt.leaflet.client.layer.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletPruneMarker extends JavaScriptObject implements LeafletLayer
{
	protected LeafletPruneMarker()
	{
	}

	/**
	 * Creates a {@link LeafletPruneMarker} for the given map
	 *
	 * @return The newly created {@link LeafletPruneMarker}
	 */
	public static LeafletPruneMarker newInstance(double latitude, double longitude)
	{
		return createJso(latitude, longitude).cast();
	}

	private static native JavaScriptObject createJso(double latitude, double longitude) /*-{
		return new $wnd.PruneCluster.Marker(latitude, longitude);
	}-*/;

	public final native LeafletPruneMarker bindPopup(String html)/*-{
		this.data.popup = html;
		return this;
	}-*/;

	public final native LeafletPruneMarker setIcon(LeafletIcon icon)/*-{
		this.data.icon = icon;
		return this;
	}-*/;

	public final native LeafletPruneMarker setCategory(int category)/*-{
		this.category = category;
		return this;
	}-*/;

	public final native LeafletPruneMarker addTo(LeafletMap map)/*-{
		this.addTo(map);
		return this;
	}-*/;
}
