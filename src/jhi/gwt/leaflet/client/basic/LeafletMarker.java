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
public class LeafletMarker extends JavaScriptObject implements LeafletLayer
{
	protected LeafletMarker()
	{
	}

	/**
	 * Creates a {@link LeafletMarker} for the given map
	 *
	 * @return The newly created {@link LeafletMarker}
	 */
	public static LeafletMarker newInstance(double latitude, double longitude)
	{
		return createJso(latitude, longitude).cast();
	}

	public static LeafletMarker newInstance(LeafletLatLng latLng)
	{
		return createJso(latLng).cast();
	}

	private static native JavaScriptObject createJso(double latitude, double longitude) /*-{
		return $wnd.L.marker([latitude, longitude]);
	}-*/;

	private static native JavaScriptObject createJso(LeafletLatLng latLng) /*-{
		return $wnd.L.marker(latLng);
	}-*/;

	public final native LeafletMarker bindPopup(String html)/*-{
		this.bindPopup(html);
		return this;
	}-*/;

	public final native LeafletMarker setIcon(LeafletIcon icon)/*-{
		this.setIcon(icon);
		return this;
	}-*/;

	public final native LeafletMarker addTo(LeafletMap map)/*-{
		this.addTo(map);
		return this;
	}-*/;

	public final native LeafletMarker openPopup()/*-{
		this.openPopup();
		return this;
	}-*/;
}
