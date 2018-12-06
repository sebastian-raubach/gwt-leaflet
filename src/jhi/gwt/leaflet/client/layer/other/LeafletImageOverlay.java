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

package jhi.gwt.leaflet.client.layer.other;

import com.google.gwt.core.client.*;

import jhi.gwt.leaflet.client.basic.*;
import jhi.gwt.leaflet.client.layer.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletImageOverlay extends JavaScriptObject implements LeafletLayer
{
	protected LeafletImageOverlay()
	{
	}

	/**
	 * Creates a {@link LeafletImageOverlay} for the given map
	 *
	 * @return The newly created {@link LeafletImageOverlay}
	 */
	public static LeafletImageOverlay newInstance(String url, LeafletLatLngBounds bounds)
	{
		return createJso(url, bounds).cast();
	}

	private static native JavaScriptObject createJso(String url, LeafletLatLngBounds bounds) /*-{
		return $wnd.L.imageOverlay(url, bounds, {
			opacity: 0.8
		});
	}-*/;

	public final native LeafletImageOverlay addTo(LeafletMap map)/*-{
		this.addTo(map);
		return this;
	}-*/;
}
