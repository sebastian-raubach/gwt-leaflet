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
public class LeafletLatLng extends JavaScriptObject
{
	protected LeafletLatLng()
	{
	}

	/**
	 * Creates a {@link LeafletLatLng} for the given map
	 *
	 * @return The newly created {@link LeafletLatLng}
	 */
	public static LeafletLatLng newInstance(double lat, double lng)
	{
		return createJso(lat, lng).cast();
	}

	public static LeafletLatLng newInstance(double lat, double lng, double altitude)
	{
		return createJso(lat, lng, altitude).cast();
	}

	private static native JavaScriptObject createJso(double lat, double lng) /*-{
		return $wnd.L.latLng(lat, lng);
	}-*/;

	private static native JavaScriptObject createJso(double lat, double lng, double altitude) /*-{
		return $wnd.L.latLng(lat, lng, altitude);
	}-*/;

	public final native double getLatitude() /*-{
		return this.lat;
	}-*/;

	public final native double getLongitude() /*-{
		return this.lng;
	}-*/;

	public final native LeafletLatLng wrap() /*-{
		return this.wrap();
	}-*/;
}
