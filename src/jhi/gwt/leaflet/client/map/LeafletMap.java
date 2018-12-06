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

package jhi.gwt.leaflet.client.map;

import com.google.gwt.core.client.*;
import com.google.gwt.dom.client.*;

import jhi.gwt.leaflet.client.basic.*;
import jhi.gwt.leaflet.client.layer.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletMap extends JavaScriptObject
{
	protected LeafletMap()
	{
	}

	/**
	 * Creates a {@link LeafletMap} for the given map
	 *
	 * @return The newly created {@link LeafletMap}
	 */
	public static LeafletMap newInstance(Element parent)
	{
		return createJso(parent).cast();
	}

	private static native JavaScriptObject createJso(Element parent) /*-{
		var openstreetmap = $wnd.L.tileLayer('//{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			id: 'OpenStreetMap',
			attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
			subdomains: ['a', 'b', 'c']
		});

		var satellite = $wnd.L.tileLayer('//server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
			id: 'Esri WorldImagery',
			attribution: 'Tiles &copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community'
		});

		var m = new $wnd.L.map(parent, {
			center: [10.0, 5.0],
			minZoom: 2,
			zoom: 2,
			layers: [openstreetmap]
		});

		var baseMaps = {
			"OpenStreetMap": openstreetmap,
			"Esri WorldImagery": satellite
		};

		new $wnd.L.control.layers(baseMaps).addTo(m);

		return m;
	}-*/;

	public native final void postponeZoomUntilFocus()/*-{
		var that = this;
		that.scrollWheelZoom.disable();
		that.on('focus', function () {
			that.scrollWheelZoom.enable();
		});
		that.on('blur', function () {
			that.scrollWheelZoom.disable();
		});
	}-*/;

	public native final void fitBounds(LeafletLatLngBounds bounds)/*-{
		this.fitBounds(bounds);
	}-*/;

	public native final void removeLayer(LeafletLayer layer)/*-{
		this.removeLayer(layer);
	}-*/;

	public native final void panTo(LeafletLatLng latlng)/*-{
		this.panTo(latlng);
	}-*/;

	public native final void setZoom(float zoom)/*-{
		this.setZoom(zoom);
	}-*/;

	public native final void setView(LeafletLatLng latlng, float zoom)/*-{
		this.setView(latlng, zoom);
	}-*/;

	public native final void setView(LeafletLatLng latLng)/*-{
		this.setView(latLng, this.getZoom());
	}-*/;

	public native final void on(String event, MapEventHandler handler)/*-{
		this.on(event, function () {
			handler.@jhi.gwt.leaflet.client.map.MapEventHandler::event()();
		})
	}-*/;

	public native final LeafletLatLng getCenter()/*-{
		return this.getCenter();
	}-*/;

	public native final void invalidateSize(boolean animate)/*-{
		this.invalidateSize(animate);
	}-*/;

	public native final Element getContainer()/*-{
		return this.getContainer();
	}-*/;

	public static native void sync(LeafletMap a, LeafletMap b)/*-{
		if (typeof $wnd.L !== 'undefined' && typeof $wnd.L.Sync !== 'undefined') {
			a.sync(b);
			b.sync(a);
		}
	}-*/;

	public static native void unsync(LeafletMap a, LeafletMap b)/*-{
		if (typeof $wnd.L !== 'undefined' && typeof $wnd.L.Sync !== 'undefined') {
			a.unsync(b);
			b.unsync(a);
		}
	}-*/;
}
